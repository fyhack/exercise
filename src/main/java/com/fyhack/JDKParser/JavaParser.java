package com.fyhack.JDKParser;

import com.sun.source.tree.*;
import com.sun.source.util.JavacTask;
import com.sun.source.util.TreeScanner;
import com.sun.tools.javac.api.JavacTool;
import com.sun.tools.javac.file.JavacFileManager;
import com.sun.tools.javac.util.Context;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;


/**
 * JavaParser
 * <p/>
 *
 * @author elc_simayi
 * @since 2016/1/13
 */
public class JavaParser {
    private JavacFileManager fileManager;
    private JavacTool javacTool;

    public JavaParser(){
        Context context = new Context();
        fileManager = new JavacFileManager(context,true, Charset.defaultCharset());
        javacTool = new JavacTool();
    }

    public void parserJavaFiles(String path){
        Iterable<? extends JavaFileObject> files = fileManager.getJavaFileObjects(path);
        JavaCompiler.CompilationTask compilationTask = javacTool.getTask(null, fileManager, null, null, null, files);
        JavacTask javacTask = (JavacTask) compilationTask;
        try {
            Iterable<? extends CompilationUnitTree> result = javacTask.parse();
            for (CompilationUnitTree compilationUnitTree : result){
                compilationUnitTree.accept(new SourceVisitor(),null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SourceVisitor extends TreeScanner<Void,Void>{
        private String currentPackageName = null;

        @Override
        public Void visitCompilationUnit(CompilationUnitTree compilationUnitTree, Void aVoid) {
            return super.visitCompilationUnit(compilationUnitTree, aVoid);
        }

        @Override
        public Void visitVariable(VariableTree variableTree, Void aVoid) {
            formatPtrln("variable name: %s, type: %s, kind: %s, package: %s",
                    variableTree.getName(), variableTree.getType(), variableTree.getKind(), currentPackageName);
            return super.visitVariable(variableTree, aVoid);
        }

        @Override
        public Void visitClass(ClassTree classTree, Void aVoid) {
            formatPtrln("class name: %s", classTree.getSimpleName());
            for (Tree member : classTree.getMembers()) {
                if (member instanceof VariableTree) {
                    VariableTree variable = (VariableTree) member;
                    List<? extends AnnotationTree> annotations = variable.getModifiers().getAnnotations();
                    if (annotations.size() > 0) {
                        formatPtrln("variable: %s, annotaion: %s", variable.getName(), annotations.get(0).getAnnotationType());
                    } else {
                        formatPtrln("variable: %s", variable.getName());
                    }
                }
            }
            return super.visitClass(classTree, aVoid);
        }
    }

    public static void formatPtrln(String format, Object... args) {
        System.out.println(String.format(format, args));
    }

    public static void main(String args[]){
        new JavaParser().parserJavaFiles("User.java");
    }
}

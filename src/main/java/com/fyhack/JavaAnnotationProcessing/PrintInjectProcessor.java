package com.fyhack.JavaAnnotationProcessing;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * PrintInjectProcessor
 * <p/>
 *
 * @author elc_simayi
 * @since 2016/8/18
 */

@SupportedAnnotationTypes("com.fyhack.JavaAnnotationProcessing.PrintInject")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class PrintInjectProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Messager messager = processingEnv.getMessager();
        for (TypeElement te : annotations) {
            for (Element e : roundEnv.getElementsAnnotatedWith(te)) {
                PrintInject printInject = e.getAnnotation(PrintInject.class);
                messager.printMessage(Diagnostic.Kind.NOTE, "Printing: " + printInject.value() + "|" + e.toString());
            }
        }
        return true;
    }
}

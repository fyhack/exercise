package com.fyhack.rmi.remote;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * RemoteServer
 * <p/>
 * 在build/classes/main/下注册 "start rmiregistry"
 * 然后启动该服务
 *
 * @author elc_simayi
 * @since 2016/8/3
 */
public class RemoteServer {
    public static final String URI = "call";

    public static void main(String args[]){
        RemoteCGI remoteCGI = new RemoteCGIImpl();
        try {
            RemoteCGI stub = (RemoteCGI) UnicastRemoteObject.exportObject(remoteCGI,8888);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind(URI,stub);
            System.out.println(URI + "Server is ready to listen");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}

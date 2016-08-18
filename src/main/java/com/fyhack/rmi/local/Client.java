package com.fyhack.rmi.local;

import com.fyhack.rmi.remote.RemoteCGI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Client
 * <p/>
 *
 * @author elc_simayi
 * @since 2016/8/3
 */
public class Client {

    public static RemoteCGI cgi;

    public static void main(String args[]){
        try {
            Registry registry = LocateRegistry.getRegistry("192.168.100.147");
            cgi = (RemoteCGI) registry.lookup("call");
            System.out.println(cgi.getString("client strs"));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}

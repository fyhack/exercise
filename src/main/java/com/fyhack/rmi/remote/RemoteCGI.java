package com.fyhack.rmi.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * RemoteCGI
 * <p/>
 *
 * @author elc_simayi
 * @since 2016/8/3
 */
public interface RemoteCGI extends Remote {
    String getString(String args) throws RemoteException;
}

package com.fyhack.rmi.remote;

import java.rmi.RemoteException;

/**
 * RemoteCGIImpl
 * <p/>
 *
 * @author elc_simayi
 * @since 2016/8/3
 */
public class RemoteCGIImpl implements RemoteCGI {
    private final String TAG = RemoteCGIImpl.class.getSimpleName();

    @Override
    public String getString(String args) throws RemoteException {
        return format(args);
    }

    private String format(String str){
        return String.format(TAG+" : %s",str);
    }

}

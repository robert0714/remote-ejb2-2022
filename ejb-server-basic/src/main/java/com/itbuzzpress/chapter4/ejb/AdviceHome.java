package com.itbuzzpress.chapter4.ejb;

import java.rmi.RemoteException;

import javax.ejb.*;

public interface AdviceHome extends EJBHome {

    public Advice create() throws CreateException, RemoteException;
}
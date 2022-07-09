package com.itbuzzpress.chapter4.ejb;

import javax.ejb.*;
import java.rmi.RemoteException;

public interface Advice extends EJBObject {

    public String getAdvice() throws RemoteException;
}
package com.itbuzzpress.chapter4.ejb.impl;

import java.rmi.RemoteException;

import javax.ejb.*;

public class AdviceBean implements SessionBean {

	private static final long serialVersionUID = 1L;

	private String[] adviceStrings = { "One word: inappropriate.", "You mightwant to    rethink that haricut.",
			"Your boss will respect " };

	public void ejbPassivate() {
		System.out.println("ejb activate");
	}

	public void ejbRemove() {
		System.out.println("ejb remove");
	}

	public void setSessionContext(SessionContext ctx) {
		System.out.println("session context");
	}

	public String getAdvice() {
		System.out.println("in get advice");
		int random = (int) (Math.random() * adviceStrings.length);
		return adviceStrings[random];
	}

	public void ejbCreate() {
		System.out.println("in get create");
	}

	public void ejbActivate() throws EJBException, RemoteException {
		System.out.println("in ejbActivate");
	}
}
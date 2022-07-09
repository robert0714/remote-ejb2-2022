 
package com.itbuzzpress.chapter4.client;

import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.itbuzzpress.chapter4.ejb.Advice;
import com.itbuzzpress.chapter4.ejb.AdviceHome;
import com.itbuzzpress.chapter4.exception.InsufficientFundsException;

import javax.naming.spi.NamingManager;
import javax.rmi.PortableRemoteObject;
/**
 * Reference <br/>
 * https://stackoverflow.com/questions/25051329/how-to-access-ejb-2-0-using-a-standalone-program
 * */
public class RemoteEJBClient {

	public static void main(String[] args) throws Exception {
		Context ic =   createInitialContextV2();

//		java:global/ejb2-server-basic/AdviceBean!com.itbuzzpress.chapter4.ejb.AdviceHome
//		java:app/ejb2-server-basic/AdviceBean!com.itbuzzpress.chapter4.ejb.AdviceHome
//		java:module/AdviceBean!com.itbuzzpress.chapter4.ejb.AdviceHome
//		java:jboss/exported/ejb2-server-basic/AdviceBean!com.itbuzzpress.chapter4.ejb.AdviceHome
//		java:global/ejb2-server-basic/AdviceBean!com.itbuzzpress.chapter4.ejb.Advice
//		java:app/ejb2-server-basic/AdviceBean!com.itbuzzpress.chapter4.ejb.Advice
//		java:module/AdviceBean!com.itbuzzpress.chapter4.ejb.Advice
//		java:jboss/exported/ejb2-server-basic/AdviceBean!com.itbuzzpress.chapter4.ejb.Advice
//		ejb:/ejb2-server-basic/AdviceBean!com.itbuzzpress.chapter4.ejb.Advice
		
	    Object o = ic.lookup("ejb:/ejb2-server-basic/AdviceBean!com.itbuzzpress.chapter4.ejb.Advice");
	    
	    // Old EJB2 style migrate to EJB3 style
//	    AdviceHome home = (AdviceHome) javax.rmi.PortableRemoteObject.narrow(o, AdviceHome.class); //This is old style 
//	    Advice advisor = home.create();
	    
	    Advice advisor = (Advice)o ;
	    System.out.println(advisor.getAdvice());


	}

	private static  Context createInitialContextV2() throws NamingException {
	final Hashtable<String, String> jndiProperties = new Hashtable<>();
    jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
    //use HTTP upgrade, an initial upgrade requests is sent to upgrade to the remoting protocol
    jndiProperties.put(Context.PROVIDER_URL,"remote+http://localhost:8080");
//  jndiProperties.put(SECURITY_PRINCIPAL, "admin");
//	jndiProperties.put(SECURITY_CREDENTIALS, "secret123!");     
    
    return new InitialContext(jndiProperties);
}
private  static Context createInitialContextV1() throws NamingException {
    Properties jndiProperties = new Properties();
    jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
    jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
    jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
    jndiProperties.put("jboss.naming.client.ejb.context", true);
//  jndiProperties.put(SECURITY_PRINCIPAL, "admin");
//	jndiProperties.put(SECURITY_CREDENTIALS, "secret123!");
  
    return new InitialContext(jndiProperties);
}
}

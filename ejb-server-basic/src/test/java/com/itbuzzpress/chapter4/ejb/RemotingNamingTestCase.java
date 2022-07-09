//package com.itbuzzpress.chapter4.ejb;
//
//import static java.util.logging.Logger.getLogger;
//import static javax.naming.Context.INITIAL_CONTEXT_FACTORY;
//import static javax.naming.Context.PROVIDER_URL;
//import static javax.naming.Context.SECURITY_CREDENTIALS;
//import static javax.naming.Context.SECURITY_PRINCIPAL;
//import static org.jboss.shrinkwrap.api.ShrinkWrap.create;
//import static org.junit.Assert.assertEquals;
//
//import java.io.File;
//import java.util.Hashtable;
//import java.util.Properties;
//import java.util.logging.Logger;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//
//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.container.test.api.RunAsClient;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.Archive;
//import org.jboss.shrinkwrap.api.asset.FileAsset;
//import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
//import org.jboss.shrinkwrap.api.spec.JavaArchive;
//import org.junit.Test;
//import org.junit.runner.RunWith;
// 
//
///**
// * You can compare it.vige.businesscomponents.transactions.XMLTestCase
// * 
// * **/
//@RunWith(Arquillian.class)
//public class RemotingNamingTestCase {
//
//	private static final Logger logger = getLogger(RemotingNamingTestCase.class.getName());
//
//	private Context context = null;
//
//	@Deployment
//	public static Archive<?> createEJBDeployment() {
//		final EnterpriseArchive ear = create(EnterpriseArchive.class, "remoting-remote-naming-test.ear");
//		
//		//It affect module name
//		final JavaArchive jar = create(JavaArchive.class, "remoting.jar");
//		
//		jar.addPackages(true , Advice.class.getPackage());
//		jar.addPackage(com.itbuzzpress.chapter4.exception.InsufficientFundsException.class.getPackage());
////		jar.addAsManifestResource(new FileAsset(new File("src/test/resources/META-INF/ejb-jar-remoting.xml")),
////				"ejb-jar.xml");
//		
//		ear.addAsModule(jar); 
//		return ear;
////		return jar;
//	}
//
//	@Test
//	public void testStatelessRemoteNaming() throws Exception {
//		logger.info("starting remoting ejb client test");
//
//		try {
//			this.context = createInitialContextV2();
//			Calculator machine = lookupV2(Calculator.class, "ejb:/ejb-server-basic/CalculatorEJB!com.itbuzzpress.chapter4.ejb.Calculator");
//			logger.info(machine + "");
//			float result = machine.calculateInterest(1000l); 
//			float expected = 1050.0f;
//			logger.info(result + ""); 
//			assertEquals(expected, result,0.5f);
//		} finally {
//			closeContext();
//		}
//	}
//
//	@Test
////	@RunAsClient
//	public void testStatefulRemoteNaming() throws Exception {
//		logger.info("starting remoting ejb client test");
//
//		try {
//			String lookupName = "ejb:/ejb-server-basic/AccountEJB!com.itbuzzpress.chapter4.ejb.Account?stateful" ;
//			this.context = createInitialContextV2();
//			Account account = lookupV2(Account.class, lookupName);
//			logger.info(account + "");
//			account.createAccount(1000l);
//			System.out.println("Deposit 250$ ");
//			account.deposit(250);
//			
//			assertEquals(account.getMoney(), 1250); 
//			
//			account   = lookupV2(Account.class, lookupName);
//			logger.info(account + "");
//			assertEquals(account.getMoney(), 0);
//		} finally {
//			closeContext();
//		}
//	}
//
//	@SuppressWarnings("unchecked")
//	private <T> T lookup(Class<T> machine, String beanName) throws NamingException {
//
//		final String appName = "remoting-remote-naming-test";
//		final String moduleName = "remoting";
//		final String distinctName = "";
//		final String viewClassName = machine.getName();
//       
//		final String lookUpName = "ejb:" + appName + "/" + moduleName + "/" + (  (distinctName.length()>0)? (distinctName+"/"):"" ) +    beanName + "!" + viewClassName;
//		System.out.println("lookUpName: " + lookUpName);
//		return (T) context.lookup(lookUpName);
//	}
//	@SuppressWarnings("unchecked")
//	private <T> T lookupV2(Class<T> machine, String lookUpName) throws NamingException {
//
//		 System.out.println("lookUpName: " + lookUpName);
//		return (T) context.lookup(lookUpName);
//	}
//
//	 
//	private static  Context createInitialContextV2() throws NamingException {
//    	final Hashtable<String, String> jndiProperties = new Hashtable<>();
//        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
//        //use HTTP upgrade, an initial upgrade requests is sent to upgrade to the remoting protocol
//        jndiProperties.put(Context.PROVIDER_URL,"remote+http://localhost:8080");
////      jndiProperties.put(SECURITY_PRINCIPAL, "admin");
////		jndiProperties.put(SECURITY_CREDENTIALS, "secret123!");     
//        
//        return new InitialContext(jndiProperties);
//    }
//    private  static Context createInitialContextV1() throws NamingException {
//        Properties jndiProperties = new Properties();
//        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
//        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
//        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
//        jndiProperties.put("jboss.naming.client.ejb.context", true);
////      jndiProperties.put(SECURITY_PRINCIPAL, "admin");
////		jndiProperties.put(SECURITY_CREDENTIALS, "secret123!");
//      
//        return new InitialContext(jndiProperties);
//    }
//
//	private  void closeContext() throws NamingException {
//		if (context != null) {
//			context.close();
//		}
//	}
//}

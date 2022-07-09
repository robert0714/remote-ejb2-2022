Remote Client EJB example for WildFly 26
=====================================
Example taken from [Practical Java EE 7 Development using WildFly application server](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example has been adapter to work on WildFly 14 and demonstrates the usage of Remote Client EJB in a Java EE Environment.

###### Test
```shell
mvn clean install exec:exec
```

# Official Document
   * [Redhat Official Document](https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.4/html/developing_jakarta_enterprise_beans_applications/invoking_session_beans#initial_context_lookup)
     * [EAP 7.4 example code](https://github.com/jboss-developer/jboss-eap-quickstarts/blob/7.4.x/ejb-remote/client/src/main/java/org/jboss/as/quickstarts/ejb/remote/client/RemoteEJBClient.java)
   * [Wildfly Official Document](https://docs.wildfly.org/26/Developer_Guide.html#Remote_Jakarta_Enterprise_Beans_invocations_via_JNDI_-_Jakarta_Enterprise_Beans_client_API_or_wildfly-naming-client_project)
     * [26.1.1 example code](https://github.com/wildfly/quickstart/blob/26.1.1.Final/ejb-remote/client/src/main/java/org/jboss/as/quickstarts/ejb/remote/client/RemoteEJBClient.java)
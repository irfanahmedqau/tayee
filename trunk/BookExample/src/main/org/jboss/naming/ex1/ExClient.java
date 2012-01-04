package org.jboss.naming.ex1;

import java.security.Security;
import java.util.Properties;
import java.net.URL;
import java.net.MalformedURLException;
import javax.naming.Context;
import javax.naming.InitialContext;

/** A simple JNDI client that uses HTTPS as the transport. 
 *
 * @author  Scott.Stark@jboss.org
 * @version $Revision: 1.1 $
 */
public class ExClient
{
    public static void main(String args[]) throws Exception
    {
        Properties env = new Properties();
        env.setProperty(Context.INITIAL_CONTEXT_FACTORY,
                        "org.jboss.naming.HttpNamingContextFactory");
        env.setProperty(Context.PROVIDER_URL,
                        "https://localhost:8443/invoker/JNDIFactorySSL");

        Context ctx = new InitialContext(env);
        System.out.println("Created InitialContext, env=" + env);

        Object data = ctx.lookup("jmx/invoker/RMIAdaptor");
        System.out.println("lookup(jmx/invoker/RMIAdaptor): " + data);
    }
}


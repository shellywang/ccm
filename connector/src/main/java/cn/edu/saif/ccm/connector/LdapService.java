/**
 * 
 */
package cn.edu.saif.ccm.connector;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/**
 * @author Siva
 *
 */
@Component
public class LdapService 
{
	RestTemplate restTemplate;
	
	LdapService ldapClient = null;//new LDAPClient();

	public synchronized LdapService getInstance() {
		if (ldapClient != null) {
			return ldapClient;
		} else
			return new LdapService();
	}

	public boolean validateUser(String username, String password) {
		LdapContext ctx = null;
		try {
			Hashtable<String, String> ldapEnv = new Hashtable<String, String>();
			ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY,
					"com.sun.jndi.ldap.LdapCtxFactory");
			ldapEnv.put(Context.PROVIDER_URL,
					"ldap://10.16.26.32:389/OU=saifUser,DC=HQ,DC=Shanghaisaif,DC=com");
			ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
			ldapEnv.put(Context.SECURITY_PRINCIPAL, "HQ\\" + username);
			ldapEnv.put(Context.SECURITY_CREDENTIALS, password); // 瀵嗙爜
			// ldapEnv.put(Context.SECURITY_PROTOCOL, "ssl");
			ctx = new InitialLdapContext(ldapEnv, null);
			return true;
		} catch (Exception e) {
			System.out.println("username:" + username
					+ " or password incorrect");
			return false;
		} finally {
			if (ctx != null) {
				try {
					ctx.close();
				} catch (NamingException e) {
					return false;
				}
			}
		}
	}

	
}


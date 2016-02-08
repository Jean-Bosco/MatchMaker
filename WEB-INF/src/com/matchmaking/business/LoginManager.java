package com.matchmaking.business;

import javax.servlet.http.*;
import com.matchmaking.domain.LoginBean;
import com.matchmaking.services.*;

import org.apache.log4j.Category;

/**
 * 
 * @author jbmudere
 * Class to validate the user's credentials 
 *
 */

public class LoginManager extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2706541587284171588L;


	Category cat = Category.getInstance("com.matchmaking");
	
	public boolean authenticate (LoginBean login) {
		Factory factory = Factory.getInstance();
		IAuthenticationSvc authenticationSvc = null;
		try {
			authenticationSvc = (IAuthenticationSvc)factory.getService(IAuthenticationSvc.NAME);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// now use the IAuthenticationSvc service 
		boolean result = false;
		try {
			result = authenticationSvc.findByLogin(login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}

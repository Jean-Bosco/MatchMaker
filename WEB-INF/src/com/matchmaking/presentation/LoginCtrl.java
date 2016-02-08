package com.matchmaking.presentation;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


import com.matchmaking.business.LoginManager;
import com.matchmaking.domain.LoginBean;

import org.apache.log4j.Category;

/**
 * @author jbmudere
 * 
 *         Servlet class to process the login from the information received from
 *         the login.html
 * 
 */

public class LoginCtrl extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("deprecation")
	Category cat = Category.getInstance("com.matchmaking");

	/**
	 * method to read the request and process the response
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		cat.info("LoginCtrl receiving request from " + request.getRemoteAddr());
		
		LoginBean user = getLoginInfo(request);

	    // Delegate to LoginManager to authenticate user
	    LoginManager loginManager = new LoginManager();
	    boolean isAuthenticated = loginManager.authenticate(user);
	    
	    if (isAuthenticated) 
		{
			// setting customer in SESSION scope
			request.getSession().setAttribute("user", user);
			
			getServletContext().getRequestDispatcher
			("/jsp/home.jsp").forward(request, response);
			cat.info("Forwarding the user to the jsp home page");
		} else {
			getServletContext().getRequestDispatcher
			("/jsp/error.jsp").forward(request, response);
			cat.info("Forwarding the user to jsp error page");
		}
	}

	/**
	 * this method turns around and invokes get to make sure both doGet and
	 * doPost are covered
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


	private LoginBean getLoginInfo(HttpServletRequest request) 
	  {
		 LoginBean user = new LoginBean(); 
		 
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");
		 		 	 
		 if ((username != null) && (password != null))
		 {	 
		  user.setUsername(username);
	  	  user.setPassword(password);
		 }
		 else
		   return null;
		 return user;
	  }
}

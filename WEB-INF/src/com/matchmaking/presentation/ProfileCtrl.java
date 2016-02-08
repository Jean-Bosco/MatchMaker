package com.matchmaking.presentation;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.log4j.Category;

import com.matchmaking.business.ProfileManager;
import com.matchmaking.domain.ProfileBean;

/**
 * Servlet class to process the creation of the profile.
 * @author jbmudere
 *
 */
public class ProfileCtrl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("deprecation")
	Category cat = Category.getInstance("com.matchmaking");
	
	/**
	 * this method turns around and invokes get to make sure both doGet and
	 * doPost are covered
	 */

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * method to read the request and process the response
	 */
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    
		ProfileBean profile = getProfileInfo(request);
		ProfileManager profileManager = new ProfileManager();
		
	    ProfileBean profileDetails = profileManager.store(profile);
	    request.getSession().setAttribute("profile", profileDetails);
		
		getServletContext().getRequestDispatcher
		("/jsp/echo.jsp").forward(request, response);
		cat.info("Dispatching to the servlet that displays the server received data");
	}
	
	private ProfileBean getProfileInfo(HttpServletRequest request) 
	  {
		 ProfileBean profile = new ProfileBean(); 
		 
		 profile.setFirstName(request.getParameter("firstName"));
		 profile.setLastName(request.getParameter("lastName"));
		 profile.setEmail(request.getParameter("email"));
		 profile.setPassword(request.getParameter("password"));
		 profile.setDescription(request.getParameter("description"));
		 profile.setInterests(request.getParameter("interests"));
		 profile.setOccupation(request.getParameter("occupation"));
		 profile.setLocation(request.getParameter("location"));
		 
		 return profile;
		
	  }

}

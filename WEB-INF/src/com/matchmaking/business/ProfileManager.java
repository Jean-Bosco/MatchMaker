package com.matchmaking.business;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.matchmaking.domain.LoginBean;
import com.matchmaking.domain.ProfileBean;
import com.matchmaking.services.Factory;
import com.matchmaking.services.IProfileSvc;
import com.matchmaking.services.ServiceLoadException;

import org.apache.log4j.Category;

/**
 * Class to echo the information submitted to the server
 */

public class ProfileManager extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4874212295388245680L;
	// get the profile and echos it for now.
	Category cat = Category.getInstance("com.matchmaking");

	public String echo(ProfileBean profile) {
		// do issues directives to echo the information sent to the server


		String detailReceived = "Here is the information you submitted to the server"+ "<br/>"
				+ "First Name: " + profile.getFirstName()+ "<br/>"
				+ "Last Name: "	+ profile.getLastName()	+ "<br/>"
				+ "Email: "	+ profile.getEmail()+ "<br/>"
				+ "Password: "	+ profile.getPassword()	+ "<br/>"
				+ "Description: "+ profile.getDescription()	+ "<br/>"
				+ "Interests: "	+ profile.getInterests()+ "<br/>"
				+ "Occupation: " + profile.getOccupation()+ "<br/>"
				+ "Location: "	+ profile.getLocation();
		cat.info(detailReceived);
		cat.info(profile.toString());
		return detailReceived;
		
	}
	public ProfileBean store (ProfileBean profile) {
		Factory factory = Factory.getInstance();
		IProfileSvc profileSvc = null;
		ProfileBean profileSaved =null; 
		try {
			profileSvc = (IProfileSvc)factory.getService(IProfileSvc.NAME);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			profileSvc.storeProfile(profile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			profileSaved =profileSvc.getProfile(profile.getEmail());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return profileSaved;
	}
}
package com.matchmaking.presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Category;

import com.matchmaking.domain.*;;

/**
 * 
 * @author jbmudere
 * Call that processes the data that reflects the data received by the server.
 */

public class EchoServlet extends HttpServlet {
	
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
	
	
	cat.info ("EchoServer receiving request from " + request.getRemoteAddr());
	// get the profile parameters
	
	String profileDetails = (String) request.getSession().getAttribute("profileDetails");
	

	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("<html>");
	out.println("<head><title>MatchMaker Created Profile</title></head>");
	out.println("<body>");
	out.println("Here is the information you submitted:" + "<br/>");
	out.println("<br/>");
	out.println(profileDetails);
	out.println("</body>");
	out.println("</html>");
	cat.info("Finished resending the data received by the server!");
	
	
	}
}

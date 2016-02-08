package com.matchmaking.presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Category;

/**
 * 
 * @author jbmudere
 * Call that processes the view data to displays once a user has failed to log in
 */
public class ErrorServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Category set in settings/log4j.properties as
		// log4j.category.com.classexercise=DEBUG, A1
		Category cat = Category.getInstance("com.matchmaking");

		cat.info("LoginServlet receiving request from "
				+ request.getRemoteAddr());

		// set the content type first
		response.setContentType("text/html");

		// get a PrintWriter
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Error Login</title></head>");
		out.println("<body><h1>");
		out.println("Invalid userid/password! Please try again!");
		out.println("</h1></body></html>");
		cat.info("Finished sending the error page data");

	} // end doGet

	/**
	 * Transfers call to doGet.
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.matchmaking.presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.PropertyConfigurator;

/**
 This servlet with its init() method is primarily used to initialize
 the Log4J logging framework.

 Tied to this class is the following entry in web.xml file

     <!-- ### Log4J Servlet Initialization -->
     <servlet>
         <servlet-name>log4J</servlet-name>
         <servlet-class>com.fleetrental.controller.servlet.log4j.Log4JServlet</servlet-class>
         <init-param>
            <param-name>propfile</param-name>
            <param-value>web-inf/log4j.properties</param-value>
         </init-param>
         <load-on-startup>1</load-on-startup>
     </servlet>

 - This entry defines a single <init-parameter> that references the location
   of the log4j properties files.
    * log4j.properties is physicaly located in ..settings\log4j.properties
      and is copied over to the web-inf folder in the buildwar target of build.xml

 - It also states that this servlet has to be loaded during starting of the
   application (in our case, start of the JBoss/Tomcat server).

 - Using this technique will aid in other J2EE components to be able to invoke log4j
   logging with little effort.

*/


public class Log4JInitServlet extends HttpServlet
{

  /**
    Initialization method that initializes logging via Log4J
  */
  public void init()throws ServletException
  {

    // Get Fully Qualified Path to Properties File
    String path = getServletContext().getRealPath("/");
    // "propfile" is initialized in web.xml (see class documentation at the top)
    String propfile = path + getInitParameter("propfile");

    // Initialize Properties for All Servlets
    PropertyConfigurator.configure(propfile);
  }


  /**
  */
  
  public void doGet(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException
  {

    PrintWriter out = response.getWriter();


    out.println("<html>");
    out.println("<head><title>Log4JServlet</title></head>");
    out.println("<body>");
    out.println("<p>The servlet has received a GET. This is the reply.</p>");
    out.println("</body></html>");
  }

  public void destroy() {

  }
}
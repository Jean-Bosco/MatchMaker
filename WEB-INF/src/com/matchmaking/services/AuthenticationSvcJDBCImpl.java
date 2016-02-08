package com.matchmaking.services;

import com.matchmaking.domain.LoginBean;
import org.apache.log4j.*;
import java.sql.*;

public class AuthenticationSvcJDBCImpl implements IAuthenticationSvc {
	@SuppressWarnings("unchecked")
	//private static Logger logger = Logger.getLogger(UserSvcJDBCImpl.class);

	private Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connString = "jdbc:mysql://localhost/matchmakingDB?"
					+ "user=root&password=";
			conn = DriverManager.getConnection(connString);
			//logger.log(Level.INFO, "Connection established successfully");

		} catch (Exception ex) {
			//logger.log(Level.ERROR, "Failed to establish MySQL connection: "
			//		+ ex.getMessage());
			throw ex;
		}
		return conn;
	}

	public boolean findByLogin(LoginBean user) throws Exception {
		System.out.println("Retrieving the stored user");
		// return new UserBean();
		Connection conn = null;
		Statement stmt = null;
		boolean isAuthenticated = false;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT username, password FROM user where username = "
					+ "'" + user.getUsername() + "'";
			
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				if (user.getUsername().equalsIgnoreCase(
						rs.getString("username"))
						&& user.getPassword().equals(rs.getString("password"))) {
					isAuthenticated = true;
					//logger.info("The user is retrieved from the database successfully.");
					System.out.println(rs.getString("username"));
					System.out.println(rs.getString("password"));
				}

			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			//logger.error("Issue reading the user from the storage.");
			throw new UserNotFoundException(
					"Unable to retrieve the user requested");
		} finally {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}

		return isAuthenticated;
	}
	public void registerUser(LoginBean user) throws Exception {
		System.out.println("Storing  the signup information, username/password");
	
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "insert into user(username,password) values('"+user.getUsername()
			+ "','" + user.getPassword() + "')";
			stmt.executeQuery(sql);
				
		} 
		catch(SQLIntegrityConstraintViolationException ex){
            System.out.println(ex.getMessage());
            //logger.error("The record exists already in the database.");
        }
		
		finally {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}

	}
	

}

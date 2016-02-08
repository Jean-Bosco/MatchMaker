package com.matchmaking.services;
import com.matchmaking.domain.*;

import org.apache.log4j.*;
import java.sql.*;

public class ProfileSvcJDBCImpl implements IProfileSvc{
	@SuppressWarnings("unchecked")
       // private static Logger logger = Logger.getLogger(ProfileSvcImpl.class);
	private Connection getConnection() throws Exception {
            Connection conn = null;
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                String connString = "jdbc:mysql://localhost/matchmakingDB?" + "user=root&password=";
                conn = DriverManager.getConnection(connString);
                //logger.log(Level.INFO, "Connection established successfully");
            } catch (Exception ex) {
               // logger.log(Level.ERROR, "Failed to establish MySQL connection: " + ex.getMessage());
                throw ex;
            }
            return conn;
        }
        public void storeProfile(ProfileBean prof)throws Exception{
		System.out.println("Storing the profile");

		//ArrayList<Profile> mylist = new ArrayList<Profile>();
                Connection conn = null;
                Statement stmt = null;
		try {
			conn = getConnection();
                        stmt = conn.createStatement();

                        String sql = "INSERT INTO profile(firstname,lastname,email,password,description,interests,occupation,location)"
                                + " VALUES ('"
                                +prof.getFirstName() + "', '"
                                +prof.getLastName() + "', '"
                                +prof.getEmail() + "', '"
                                +prof.getPassword() + "', '"
                                +prof.getDescription() + "', '"
                                +prof.getInterests() + "', '"
                                +prof.getOccupation()+ "', '"
                                +prof.getLocation()+ "')";
                        stmt.executeUpdate (sql);
                       // logger.info("The profile stored successfully into the database.");
                }
		catch(SQLIntegrityConstraintViolationException ex){
                   System.out.println(ex.getMessage());
                   //logger.error("The record exists already in the database.");
               }

               catch(Exception ex){
                   System.out.println(ex.getMessage());
                   //logger.error("Issue retrieving the type profile");
                   throw new ServiceLoadException("Unable to store the profile.");
               }
                finally {
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
               }
	
	}
	
	public ProfileBean getProfile(String email) throws Exception{
		System.out.println ("Retrieving the stored profile");
		
		ProfileBean prof = null;
                Connection conn = null;
                Statement stmt = null;
		
		//ArrayList<Profile> mylist = new ArrayList<Profile>();
		try {
			conn = getConnection();
                        stmt = conn.createStatement();
                        String sql = "SELECT * FROM profile where email = '" + email+"'";
                        System.out.println("Query: "+sql);

                        ResultSet rs = stmt.executeQuery (sql);
                       

                        while (rs.next()) {
                            prof = new ProfileBean();
                            prof.setFirstName(rs.getString("firstname"));
                            prof.setLastName(rs.getString("lastname"));
                            prof.setEmail(rs.getString("email"));
                            prof.setPassword(rs.getString("password"));
                            prof.setDescription(rs.getString("description"));
                            prof.setInterests(rs.getString("interests"));
                            prof.setOccupation(rs.getString("occupation"));
                            prof.setLocation(rs.getString("location"));
                            //logger.info("The profile is retrieved from the database successfully.");
                        }
		}
		catch (Exception e){
			System.out.println(e.getMessage());
                      //  logger.error("Issue reading the profile from the storage.");
			throw new ProfileNotFoundException("Unable to retrieve the profile requested");
		}
                finally {
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                }
                return prof;
	}
	

}

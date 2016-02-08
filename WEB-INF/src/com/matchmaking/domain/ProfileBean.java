package com.matchmaking.domain;

import java.io.Serializable;

public class ProfileBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5250360758772864220L;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String description;
	private String interests;
	private String occupation;
	private String location;
	
	public ProfileBean(){
	}
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public boolean equals(ProfileBean p) {
		if (!p.getFirstName().equals(firstName)) return false;
		if (!p.getLastName().equals(lastName)) return false;
		if (!p.getEmail().equals(email)) return false;
		if (!p.getPassword().equals(password)) return false;
		if (!p.getDescription().equals(description)) return false;
		if (!p.getInterests().equals(interests)) return false;
		if (!p.getOccupation().equals(occupation)) return false;
		if (!p.getLocation().equals(location)) return false;
		return true;
	}

	/**
	 * Constructs a <code>String</code> with all attributes
	 * in name = value format.
	 *
	 * @return a <code>String</code> representation 
	 * of this object.
	 */
	public String toString()
	{
	    final String TAB = "    ";
	    
	    String retValue = "";
	    
	    retValue = "ProfileBean ( "
	        + super.toString() + TAB
	        + "firstName = " + this.firstName + TAB
	        + "lastName = " + this.lastName + TAB
	        + "email = " + this.email + TAB
	        + "password = " + this.password + TAB
	        + "description = " + this.description + TAB
	        + "interests = " + this.interests + TAB
	        + "occupation = " + this.occupation + TAB
	        + "location = " + this.location + TAB
	        + " )";
	
	    return retValue;
	}

}

package com.matchmaking.domain;

public class LoginBean {
	public LoginBean() {
	}

	private String username;
	private String password;

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public boolean equals(LoginBean u) {
		if (!u.getUsername().equals(username))
			return false;
		if (!u.getPassword().equals(password))
			return false;
		return true;
	}

	/**
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	public String toString() {
		final String TAB = "    ";

		String retValue = "";

		retValue = "LoginBean ( " + super.toString() + TAB + "username = "
				+ this.username + TAB + "password = " + this.password + TAB
				+ " )";

		return retValue;
	}
}

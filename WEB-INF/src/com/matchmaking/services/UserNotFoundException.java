package com.matchmaking.services;
import java.io.Serializable;

public class UserNotFoundException extends Exception implements Serializable{
	private static final long serialVersionUID = 2960217165150639717L;

	public UserNotFoundException(final String message) {
		super(message);
	}
}

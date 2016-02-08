package com.matchmaking.services;
import java.io.Serializable;
public class ProfileNotFoundException extends Exception implements Serializable{

	private static final long serialVersionUID = -6595291968835214296L;

	public ProfileNotFoundException(final String message) {
		super(message);
	}
}

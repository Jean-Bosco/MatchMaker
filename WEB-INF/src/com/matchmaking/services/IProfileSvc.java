package com.matchmaking.services;
import com.matchmaking.domain.*;
public interface IProfileSvc extends IService{
	public final String NAME = "IProfileSvc";
	public void storeProfile(ProfileBean prof) throws Exception;
	public ProfileBean getProfile(String email) throws Exception;
}


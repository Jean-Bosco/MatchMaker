
package com.matchmaking.services;
import com.matchmaking.domain.*;

public interface IAuthenticationSvc extends IService{
  
    public final String NAME = "IAuthenticationSvc";

	public boolean findByLogin(LoginBean user) throws Exception;
	public void registerUser(LoginBean user) throws Exception;
}

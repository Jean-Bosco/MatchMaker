package com.matchmaking.services;

import javax.naming.Context;
import javax.naming.InitialContext;
import org.apache.log4j.*;

public class Factory {
	private Factory() {
	};

	private static Logger logger = Logger.getLogger(Factory.class);
	private static Factory factory = new Factory();

	public static Factory getInstance() {
		return factory;
	}

	public IService getService(String name) throws ServiceLoadException {
		try {
			Class c = Class.forName(getImplName(name));
			return (IService) c.newInstance();
		} 
		catch (ClassNotFoundException e) {
			throw new ServiceLoadException(name + " not found");
		} catch (InstantiationException e) {
			throw new ServiceLoadException(name + " not instantiated");
		} catch (IllegalAccessException e) {
			throw new ServiceLoadException(name + "illegal access");
		} catch (Exception e) {
			throw new ServiceLoadException(name + "not loaded");
		}
		
	}


	private String getImplName(String serviceName) throws Exception {
	     Context iniCtx = new InitialContext();
	     Context envCtx = (Context) iniCtx.lookup("java:comp/env");
	     return (String)envCtx.lookup(serviceName);
	}


	
}
package com.cruat.oauth.common;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public enum Setting {
	DATASOURCE("java:comp/env/jdbc/datasource");
	
	public static Object value(Setting setting){
		try{
			Context init = new InitialContext();
			String lookupName = setting.getName();
			return init.lookup(lookupName);
		}
		catch(NamingException e){
			String err = "Unable to access Setting \"%s\"";
			err = String.format(err, setting.getName());
			throw new IllegalStateException(err);
		}
	}
	
	private String name;
	
	private Setting(String name){
		setName(name);
	}
	
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
	
	public Object getValue(){
		return value(this);
	}
}

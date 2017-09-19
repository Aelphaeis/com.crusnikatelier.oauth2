package com.crusnikatelier.oauth2.configuration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public enum Setting {
	DATASOURCE("jdbc/mysql/datasource");
	
	public static Object value(Setting setting){
		try{
			Context init = new InitialContext();
			String lookupName = setting.getName();
			return init.lookup(lookupName);
		}
		catch(NamingException e){
			String err = "Unable to access Setting \"%s\"";
			throw new IllegalStateException(String.format(err, setting.getName()));
		}
	}
	
	String name;
	
	Setting(String name){
		setName(name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Object getValue(String name){
		return value(this);
	}
}

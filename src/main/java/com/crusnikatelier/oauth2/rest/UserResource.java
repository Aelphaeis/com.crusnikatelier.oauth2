package com.crusnikatelier.oauth2.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import com.crusnikatelier.oauth2.rest.forms.CreateUserForm;

@Path("user")
public class UserResource {
	
	@Context
	HttpServletRequest request;
	
	
	@POST
	public void createUser(CreateUserForm form){
		
		
	}
	
	public void modifyUser(){
		//TODO implement 
	}
	
	public void getUser(){
		//TODO implement 
	}
	
	public void deleteUser(){
		//TODO implement 
	}
}

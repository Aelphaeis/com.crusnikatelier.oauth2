package com.crusnikatelier.oauth2.rest;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.crusnikatelier.oauth2.dto.UserDTO;
import com.crusnikatelier.oauth2.rest.forms.CreateUserForm;
import com.crusnikatelier.oauth2.utilities.Users;

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
	
	@GET
	@Path("me")
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO getUser(){
		UserDTO dto = new UserDTO();
		dto.setJoined(new Date());
		dto.setUsername("Aelphaeis");
		dto.setGuid(Users.generateUserGuid());
		return dto;
	}

	public void deleteUser(){
		//TODO implement 
	}
}

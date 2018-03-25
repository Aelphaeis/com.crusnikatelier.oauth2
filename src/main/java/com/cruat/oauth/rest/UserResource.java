package com.cruat.oauth.rest;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.cruat.oauth.dto.UserDTO;
import com.cruat.oauth.rest.forms.CreateUserForm;
import com.cruat.oauth.services.UserService;
import com.cruat.oauth.utilities.Users;

@Path("user")
public class UserResource {

	@Context
	HttpServletRequest request;

	UserService userService;

	@Autowired
	public UserResource(UserService uService) {
		setUserService(uService);
	}
	
	@POST
	@Path("/register")
	public void createUser(CreateUserForm form) {
		String email = form.getEmail();
		String pass = form.getPassword();
		userService.createUser(email, pass);
	}

	public void modifyUser() {
	}

	@GET
	@Path("me")
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO getUser() {
		UserDTO dto = new UserDTO();
		dto.setJoined(new Date());
		dto.setUsername("Aelphaeis");
		dto.setGuid(Users.generateUserGuid());
		return dto;
	}

	public void deleteUser() {
		// TODO implement
	}

	protected UserService getUserService() {
		return userService;
	}

	protected void setUserService(UserService userService) {
		this.userService = userService;
	}
}

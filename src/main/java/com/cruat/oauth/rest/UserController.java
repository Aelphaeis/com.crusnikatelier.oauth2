package com.cruat.oauth.rest;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cruat.oauth.dto.UserDTO;
import com.cruat.oauth.rest.forms.CreateUserForm;
import com.cruat.oauth.services.UserService;
import com.cruat.oauth.utilities.Users;

@RestController
public class UserController {

	HttpServletRequest request;

	UserService userService;

	@Autowired
	public UserController(UserService uService) {
		setUserService(uService);
	}

	public void createUser(CreateUserForm form) {
		String email = form.getEmail();
		String pass = form.getPassword();
		userService.createUser(email, pass);
	}

	public void modifyUser() {
		//TODO implement me
	}

	@GetMapping("me")
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

package com.cruat.oauth.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cruat.oauth.rest.forms.CreateUserForm;
import com.cruat.oauth.services.UserService;

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

	@GetMapping("me")	
	public @ResponseBody String test() {
		return "test";
	}

	protected UserService getUserService() {
		return userService;
	}

	protected void setUserService(UserService userService) {
		this.userService = userService;
	}
}

package com.cruat.oauth.feature.users;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	HttpServletRequest request;

	private UserService userService;

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
	
	@GetMapping("obj")	
	public @ResponseBody CreateUserForm test2() {
		CreateUserForm fm = new CreateUserForm();
		fm.setEmail("a");
		fm.setPassword("e");
		return fm;
	}

	protected UserService getUserService() {
		return userService;
	}

	protected void setUserService(UserService userService) {
		this.userService = userService;
	}
}

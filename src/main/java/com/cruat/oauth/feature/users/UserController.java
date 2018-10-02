package com.cruat.oauth.feature.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cruat.oauth.common.data.entities.User;

@RestController("users")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService uService) {
		setUserService(uService);
	}

	@PostMapping
	public UserDTO createUser(CreateUserForm form) {
		String email = form.getEmail();
		String pass = form.getPassword();
		User user = userService.createUser(email, pass);
		return new UserDTO(user);
	}
	
	protected UserService getUserService() {
		return userService;
	}

	protected void setUserService(UserService userService) {
		this.userService = userService;
	}
}

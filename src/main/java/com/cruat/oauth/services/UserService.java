package com.cruat.oauth.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cruat.oauth.common.data.dao.UserDAO;
import com.cruat.oauth.common.data.entities.User;
import com.cruat.oauth.utilities.Users;

@Component
public class UserService {
	
	UserDAO userDAO;
	
	@Autowired
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * Creates a user using an email address and a password and returns a unique GUID that can be used to reference the
	 * user. The GUID returned will be exactly 36 characters long.
	 * @param email
	 * @param pass
	 * @return GUID
	 */
	public String createUser(String email, String pass) {

		String salt = Users.generateUserSalt();
		String guid = Users.generateUserGuid();
		String hash = Users.hashPassword(pass, salt);
		
		User user = new User();
		user.setEmail(email);
		user.setJoined(new Date());
		user.setSalt(salt);
		user.setGuid(guid);
		user.setHash(hash);
		
		userDAO.create(user);
		
		return guid;
	}

}

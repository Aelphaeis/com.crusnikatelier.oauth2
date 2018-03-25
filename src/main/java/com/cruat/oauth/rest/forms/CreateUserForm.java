package com.cruat.oauth.rest.forms;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.cruat.oauth.exceptions.AggregationException;
import com.cruat.oauth.rest.UserResource;

/**
 * This class represents the information necessary to create a user.
 * 
 * @see UserResource#createUser
 * @author Aelphaeis
 */
@XmlRootElement
public class CreateUserForm implements Form {
	String email;
	String password;

	@Override
	public void validate() throws AggregationException {
		List<ValidationException> exceptions = new ArrayList<>();
		if (email == null || email.isEmpty()) {
			String err = "email cannot be null or blank";
			exceptions.add(new ValidationException(err));
		}
		if (password == null || password.isEmpty()) {
			String err = "password cannot be null or blank";
			exceptions.add(new ValidationException(err));
		}
		if (!exceptions.isEmpty()) {
			String err = "an error occurred during validation";
			throw new AggregationException(err, exceptions);
		}
	}

	@XmlElement
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlElement
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

package com.cruat.oauth.feature.users;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.cruat.oauth.common.data.DataAccessObject;
import com.cruat.oauth.common.data.entities.User;

@Component
public class UserDAO implements DataAccessObject<User> {

	@Override
	public Session getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<User> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}
}

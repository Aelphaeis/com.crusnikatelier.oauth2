package com.cruat.oauth.feature.users;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.cruat.oauth.common.data.DataAccessObject;
import com.cruat.oauth.common.data.entities.User;

@Repository
public class UserDAO implements DataAccessObject<User> {
	
	private SessionFactory factory;
	
	public UserDAO(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}
}

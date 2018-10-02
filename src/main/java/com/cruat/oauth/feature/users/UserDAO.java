package com.cruat.oauth.feature.users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.stereotype.Repository;

import com.cruat.oauth.common.data.DataAccessObject;
import com.cruat.oauth.common.data.entities.User;

@Repository
public class UserDAO implements DataAccessObject<User> {
	
	private final EntityManager manager;
	
	public UserDAO(EntityManagerFactory factory) {
		this.manager = factory.createEntityManager();
	}

	@Override
	public EntityManager getEntityManager() {
		return manager;
	}

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}
}

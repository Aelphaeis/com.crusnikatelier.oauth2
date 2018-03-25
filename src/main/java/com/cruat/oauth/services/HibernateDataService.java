package com.cruat.oauth.services;

import java.io.Closeable;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateDataService implements Closeable {
	private static final HibernateDataService instance = new HibernateDataService();

	public static final HibernateDataService getInstance() {
		return instance;
	}

	private SessionFactory sessionFactory;

	private HibernateDataService() {
		// Build Service Registry
		StandardServiceRegistry registry = null;
		StandardServiceRegistryBuilder builder = null;
		builder = new StandardServiceRegistryBuilder();
		builder.configure();
		registry = builder.build();

		MetadataSources sources = new MetadataSources(registry);
		Metadata metadata = sources.buildMetadata();
		sessionFactory = metadata.buildSessionFactory();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public void close() {

	}

}

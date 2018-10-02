package com.cruat.oauth.common;

import java.io.Closeable;

import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class HibernateDataService implements Closeable {

	private SessionFactory sessionFactory;

	public HibernateDataService() {
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

	@Bean
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	@PreDestroy
	public void close() {
		sessionFactory.close();
	}

}

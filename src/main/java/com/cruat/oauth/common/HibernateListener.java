package com.cruat.oauth.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.cruat.oauth.services.HibernateDataService;

/**
 * Application Lifecycle Listener implementation class HibernateListener
 *
 */
public class HibernateListener implements ServletContextListener {

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// Initialize Hibernate here.
		HibernateDataService.getInstance();
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// Cleanup Hibernate here
		HibernateDataService.getInstance().close();
	}

}

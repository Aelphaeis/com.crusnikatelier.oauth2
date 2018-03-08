package com.crusnikatelier.oauth2.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.crusnikatelier.oauth2.services.HibernateDataService;

/**
 * Application Lifecycle Listener implementation class HibernateListener
 *
 */
public class HibernateListener implements ServletContextListener {

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	//Initialize Hibernate here.
    	HibernateDataService.getInstance();
    }
    
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  {
    	//Cleanup Hibernate here
    	HibernateDataService.getInstance().close();
    }
	
}

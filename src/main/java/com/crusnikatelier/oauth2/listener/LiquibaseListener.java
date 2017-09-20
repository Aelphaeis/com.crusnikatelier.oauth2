package com.crusnikatelier.oauth2.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import liquibase.integration.servlet.LiquibaseServletListener;

/**
 * Application Lifecycle Listener implementation class LiquibaseListener
 *
 */
@WebListener
public class LiquibaseListener extends LiquibaseServletListener implements ServletContextListener {
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	super.contextInitialized(sce);
    }
}

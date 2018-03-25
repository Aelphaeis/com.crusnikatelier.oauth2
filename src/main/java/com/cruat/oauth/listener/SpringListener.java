package com.cruat.oauth.listener;



import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Lifecycle Listener implementation class SpringListener
 *
 */
@WebListener
public class SpringListener implements ServletContextListener {
	private static final Logger logger = LogManager.getLogger(SpringListener.class);
	private static final String LOCATION = "context.xml";
	ConfigurableApplicationContext ctxt;

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	ctxt = new ClassPathXmlApplicationContext(LOCATION);
    	for(String name : ctxt.getBeanDefinitionNames()) {
    		logger.info(name);
    	}
    }
	
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	ctxt.close();
    }

}

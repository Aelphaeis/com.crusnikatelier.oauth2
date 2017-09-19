package com.crusnikatelier.oauth2.listener;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.crusnikatelier.oauth2.configuration.Setting;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.ResourceAccessor;

/**
 * Application Lifecycle Listener implementation class LiquibaseListener
 *
 */
@WebListener
public class LiquibaseListener implements ServletContextListener {
	public static final String CHANGELOG_PATH = "changelogs/changelog.xml";
	private static final Logger logger = LogManager.getLogger(LiquibaseListener.class);

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	logger.trace("Running Liquibase");
		long start = System.currentTimeMillis();

		try{
			DataSource ds = (DataSource)Setting.DATASOURCE.getValue();
			DatabaseFactory dbFactory = DatabaseFactory.getInstance();

			JdbcConnection connection = new JdbcConnection(ds.getConnection());
			Database db = dbFactory.findCorrectDatabaseImplementation(connection);
			ResourceAccessor accessor = new ClassLoaderResourceAccessor();
			Liquibase liquibase = new Liquibase(CHANGELOG_PATH, accessor, db);
			liquibase.update(new Contexts(), new LabelExpression());
		}
		catch (SQLException | LiquibaseException e) {
			String msg = "Unable to run Liquibase";
			throw new IllegalStateException(msg, e);
		}
		
		long end = System.currentTimeMillis();
		String msg = "Liquibase has successful ran in {} millseconds";
		logger.info(msg, end - start);
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}

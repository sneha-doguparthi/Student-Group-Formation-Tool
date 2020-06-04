package com.asdc.group6.DBConnection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.asdc.group6.Utilities.ApplicationConstants;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Component
public class CreateDatabaseConnection {
	
	static Connection dbConnection;
	private static Properties applicationProperties, dbProperties;
	private static String applicationConfigFile;
	private static InputStream applicationPropertiesStream, activeDbPropertiesStream;
	private static Map<String, String> dbCredentials = new HashMap<String, String>();
	private static Logger logger = LogManager.getLogger(CreateDatabaseConnection.class);

	private static void setDatabaseConfigurations() {
		try {
			applicationConfigFile = "application.properties";
			applicationPropertiesStream = CreateDatabaseConnection.class.getClassLoader()
					.getResourceAsStream(applicationConfigFile);
			applicationProperties = new Properties();
			applicationProperties.load(applicationPropertiesStream);
			String activeDb = applicationProperties.getProperty("database.active");

			activeDbPropertiesStream = CreateDatabaseConnection.class.getClassLoader().getResourceAsStream(activeDb);
			dbProperties = new Properties();
			dbProperties.load(activeDbPropertiesStream);

			dbCredentials.put("dbname", dbProperties.getProperty("dbname"));
			dbCredentials.put("username", dbProperties.getProperty("username"));
			dbCredentials.put("password", dbProperties.getProperty("password"));
			dbCredentials.put("server", dbProperties.getProperty("server"));
			dbCredentials.put("port", dbProperties.getProperty("port"));
		} catch (IOException e) {
			logger.error("Exception occured while loading database configuration file ", e);
		}

	}

	public static Connection createConnection() {
		setDatabaseConfigurations();
		String user = dbCredentials.get("username");
		String password = dbCredentials.get("password");
		String database = dbCredentials.get("dbname");
		String server = dbCredentials.get("server");
		String port = dbCredentials.get("port");
		String connectionUrl = "jdbc:mysql://" + server + ":" + port + "/" + database+"?serverTimezone=UTC";
		try {
			Class.forName(ApplicationConstants.DB_DRIVER_NAME).getClass();
			dbConnection = DriverManager.getConnection(connectionUrl, user, password);
		} catch (Exception e) {
			logger.error("Error occured while connecting to remote database : " + e);
		}
		return dbConnection;
	}

	public static boolean closeConnection() {
		try {
			if (null != dbConnection && !(dbConnection.isClosed()))
				dbConnection.close();
		} catch (SQLException e) {
			logger.error("Exception occurred while closing database connection " + e);
		}
		return true;
	}

}

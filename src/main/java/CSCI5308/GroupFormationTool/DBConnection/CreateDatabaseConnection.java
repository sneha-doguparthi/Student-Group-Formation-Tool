package CSCI5308.GroupFormationTool.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import CSCI5308.GroupFormationTool.SystemConfig;

// Singleton for retrieving connections.
public class CreateDatabaseConnection {
	static Connection dbConnection;
	private static CreateDatabaseConnection uniqueInstance = null;

	private String dbURL;
	private String dbUserName;
	private String dbPassword;

	private CreateDatabaseConnection() {
		IDatabaseConfiguration config = SystemConfig.instance().getDatabaseConfiguration();
		dbURL = config.getDatabaseURL();
		dbUserName = config.getDatabaseUserName();
		dbPassword = config.getDatabasePassword();
	}

	public static CreateDatabaseConnection instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new CreateDatabaseConnection();
		}
		return uniqueInstance;
	}

	public Connection createConnection() throws SQLException {
		dbConnection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
		return dbConnection;
	}

	public static boolean closeConnection() {
		try {
			if (null != dbConnection && !(dbConnection.isClosed()))
				dbConnection.close();
		} catch (SQLException e) {
//			logger.error("Exception occurred while closing database connection " + e);
		}
		return true;
	}
}

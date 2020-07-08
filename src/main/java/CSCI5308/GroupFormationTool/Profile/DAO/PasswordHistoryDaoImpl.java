package CSCI5308.GroupFormationTool.Profile.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.DBUtil.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.Model.PasswordHistory;

public class PasswordHistoryDaoImpl implements PasswordHistoryDao {

	Logger logger = LogManager.getLogger(PasswordHistoryDaoImpl.class);

	@Override
	public Boolean insert(String email, String password) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			String insertQuery = "INSERT INTO password_history (email,password) values(?,?);";
			statement = connection.prepareStatement(insertQuery);
			statement.setString(1, email);
			statement.setString(2, password);
			statement.executeUpdate();
		} catch (SQLException exception) {
			logger.error("SQL exception in method insert", exception);
			return false;
		} finally {
			try {
				if (null != statement)
					statement.close();
				if (null != connection)
					connection.close();
			} catch (SQLException exception) {
				logger.error("SQL exception while closing connection", exception);
			}
		}

		return true;
	}

	@Override
	public ArrayList<PasswordHistory> fetch(String email, Integer limit) {

		Connection connection = null;
		Statement statement = null;
		ArrayList<PasswordHistory> list = new ArrayList<>();

		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			statement = connection.createStatement();
			String query = "SELECT * FROM password_history WHERE email = '" + email + "' ORDER BY id DESC LIMIT "
					+ limit;
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				PasswordHistory passwordHistory = new PasswordHistory();
				passwordHistory.setId(rs.getInt("id"));
				passwordHistory.setEmail(rs.getString("email"));
				passwordHistory.setPassword(rs.getString("password"));
				list.add(passwordHistory);
			}
		} catch (SQLException exception) {
			logger.error("SQL exception in method fetch", exception);
			return null;
		} finally {
			try {
				if (null != statement)
					statement.close();
				if (null != connection)
					connection.close();
			} catch (SQLException exception) {
				logger.error("SQL exception while closing connection", exception);
			}
		}

		return list;
	}

}

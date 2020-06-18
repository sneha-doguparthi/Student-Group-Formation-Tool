package CSCI5308.GroupFormationTool.ToolAdmin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.DBConnection.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.Utilities.ApplicationConstants;

public class AssignInstructorImpl implements AssignInstructor {

	private Logger logger = LogManager.getLogger(AssignInstructorImpl.class);

	@Override
	public ArrayList<User> getUserList() {

		Connection connection = null;
		PreparedStatement statement = null;
		ArrayList<User> userList = new ArrayList<>();

		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			String selectQuery = "SELECT first_name, last_name, user_id, banner_id, email FROM user WHERE user_type != 'A';";
			statement = connection.prepareStatement(selectQuery);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setUserId(resultSet.getInt("user_id"));
				user.setFirstName(resultSet.getString("first_name"));
				user.setLastName(resultSet.getString("last_name"));
				user.setBannerId(resultSet.getString("banner_id"));
				user.setEmail(resultSet.getString("email"));
				userList.add(user);
			}
		} catch (SQLException e) {
			logger.error("Exception occured while fetching the user list", e);
		} finally {
			try {
				if (null != statement) {
					statement.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (SQLException e) {
				logger.error("Exception occured while closing connection/statement", e);
			}
		}

		return userList;
	}

	@Override
	public String assignRoleToUser(User user, String courseCode) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			if (checkIfCourseExistsForUser(user, courseCode))
				return ApplicationConstants.COURSE_ALREADY_ADDED_FOR_USER;
			connection = CreateDatabaseConnection.instance().createConnection();
			String insertQuery = "INSERT INTO course_association (course_id,user_id, role_id) values(?,?,?);";
			statement = connection.prepareStatement(insertQuery);
			statement.setString(1, courseCode);
			statement.setInt(2, user.getUserId());
			statement.setInt(3, ApplicationConstants.INSTRUCTOR_ROLE_ID);
			int result = statement.executeUpdate();
			if (result > 0)
				return ApplicationConstants.COURSE_ROLE_SUCCESS;
		} catch (SQLException e) {
			logger.error("Exception occured while adding new course", e);
		} finally {
			try {
				if (null != statement) {
					statement.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (SQLException e) {
				logger.error("Exception occured while closing connection/statement", e);
			}
		}

		return ApplicationConstants.COURSE_ROLE_FAILED;
	}

	@Override
	public boolean checkIfCourseExistsForUser(User user, String course) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			String selectQuery = "SELECT ca.course_id FROM course_association ca JOIN user u ON u.user_id = ca.user_id WHERE ca.course_id = ?;";
			statement = connection.prepareStatement(selectQuery);
			statement.setString(1, course);
			ResultSet resultSet = statement.executeQuery();
			int size = 0;
			while (resultSet.next()) {
				size++;
			}
			if (size > 0)
				return true;
		} catch (SQLException e) {
			logger.error("Exception occured while checking if course exists for user", e);
		} finally {
			try {
				if (null != statement) {
					statement.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (SQLException e) {
				logger.error("Exception occured while closing connection/statement", e);
			}
		}

		return false;
	}

}

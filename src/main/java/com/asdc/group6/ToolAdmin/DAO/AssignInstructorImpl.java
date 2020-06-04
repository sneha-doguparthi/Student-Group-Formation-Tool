package com.asdc.group6.ToolAdmin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.asdc.group6.DBConnection.CreateDatabaseConnection;
import com.asdc.group6.Models.User;
import com.asdc.group6.Utilities.ApplicationConstants;

public class AssignInstructorImpl implements AssignInstructor {

	private Logger logger = LogManager.getLogger(AssignInstructorImpl.class);

	@Override
	public ArrayList<User> getUserList() {
		Connection connection = null;
		PreparedStatement statement = null;
		ArrayList<User> userList = new ArrayList<>();
		try {
			connection = CreateDatabaseConnection.createConnection();
			String selectQuery = "SELECT first_name, last_name, user_id, banner_id, email FROM user;";
			statement = connection.prepareStatement(selectQuery);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setUserId(resultSet.getString("user_id"));
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
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
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
			connection = CreateDatabaseConnection.createConnection();
			String insertQuery = "INSERT INTO course_association (course_id,user_id, role_id) values(?,?,?);";
			statement = connection.prepareStatement(insertQuery);
			statement.setString(1, courseCode);
			statement.setString(2, user.getUserId());
			statement.setInt(3, ApplicationConstants.INSTRUCTOR_ROLE_ID);
			int result = statement.executeUpdate();
			if (result > 0)
				return ApplicationConstants.COURSE_ROLE_SUCCESS;
		} catch (SQLException e) {
			logger.error("Exception occured while adding new course", e);
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
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
			connection = CreateDatabaseConnection.createConnection();
			String selectQuery = "SELECT ca.course_id FROM course_association ca JOIN User u ON u.user_id = ca.user_id WHERE ca.course_id = ?;";
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
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				logger.error("Exception occured while closing connection/statement", e);
			}
		}
		return false;
	}
}
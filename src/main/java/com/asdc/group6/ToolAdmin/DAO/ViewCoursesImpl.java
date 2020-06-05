package com.asdc.group6.ToolAdmin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.asdc.group6.DBConnection.CreateDatabaseConnection;
import com.asdc.group6.Models.Course;

public class ViewCoursesImpl implements ViewCourses {
	private Logger logger = LogManager.getLogger(ViewCoursesImpl.class);

	@Override
	public ArrayList<Course> getCourseList() {
		Connection connection = null;
		PreparedStatement statement = null;
		ArrayList<Course> courseData = new ArrayList<>();
		try {
			connection = CreateDatabaseConnection.createConnection();
			String selectQuery = "SELECT course_id, course_code, course_name FROM course;";
			statement = connection.prepareStatement(selectQuery);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Course tempCourseObj = new Course();
				tempCourseObj.setCourseCode(resultSet.getString("course_code"));
				tempCourseObj.setCourseName(resultSet.getString("course_name"));
				tempCourseObj.setCourseId(resultSet.getString("course_id"));
				courseData.add(tempCourseObj);
			}
		} catch (SQLException e) {
			logger.error("Exception occured while fetching the course list", e);
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
		return courseData;
	}
}
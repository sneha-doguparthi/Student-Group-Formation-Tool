package com.asdc.group6.Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.asdc.group6.DBConnection.CreateDatabaseConnection;
import com.asdc.group6.Models.Course;
import com.asdc.group6.Models.User;

@Component
public class UserCourses {

	public boolean fetchCourses(User user, Course course) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "select course_code,course_name from course where course_id in (select course_id from course_association where user_id = ?)";
		try {
			connection = CreateDatabaseConnection.createConnection();
			statement = connection.prepareStatement(query);
			statement.setLong(1, user.getUserId());
			ResultSet rs = statement.executeQuery();
			if (rs.next() == false)
				return false;
			else {
				List<Course> userCourses = new ArrayList<Course>();
				while (rs.next()) {
					course.setCourseCode(rs.getString("course_code"));
					course.setCourseName(rs.getString("course_name"));
					userCourses.add(course);
				}
				course.setCourseList(userCourses);
				return true;
			}
		} catch (SQLException exception) {
			return false;
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {

			}
		}
	}
}

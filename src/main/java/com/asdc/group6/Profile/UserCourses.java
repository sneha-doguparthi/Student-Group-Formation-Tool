package com.asdc.group6.Profile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asdc.group6.DBConnection.CreateDatabaseConnection;
import com.asdc.group6.Models.Course;
import com.asdc.group6.Models.User;

@Component
public class UserCourses {
	@Autowired
	private CreateDatabaseConnection db;
	
	public boolean fetchCourses(User user,Course course) {
		Statement statement= null;
		String query= "select course_code,course_name from course where course_id in (select course_id from course_association where user_id = "+ user.getUserId()+")";
		try {
			statement = db.createConnection().createStatement();
			ResultSet rs= statement.executeQuery(query);
			if(rs.next()==false)
				return false;
			else {
				List<Course> userCourses = new ArrayList<Course>();
				//userCourses.add(rs.getString("course_name"));
				while(rs.next()) {
					course.setCourseCode(rs.getString("course_code"));
					course.setCourseName(rs.getString("course_name"));
					userCourses.add(course);
				}
				course.setCourseList(userCourses);
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}

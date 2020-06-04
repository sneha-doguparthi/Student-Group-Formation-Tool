package com.asdc.group6.Profile.Login.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.stereotype.Component;
import com.asdc.group6.DBConnection.CreateDatabaseConnection;
import com.asdc.group6.Models.Course;

@Component
public class CourseDaoImpl implements CourseDao {

	@Override
	public ArrayList<Course> getAll() {
		
		Connection connection = null;
		Statement statement = null;
		String query = "SELECT * FROM course";
		
		ArrayList<Course> courses = new ArrayList<>();
		
		try {
			
			connection = CreateDatabaseConnection.createConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
						
			while(rs.next()) {
				Course course = new Course();
				
				course.setCourseId(rs.getString("course_id"));
				course.setCourseCode(rs.getString("course_code"));
				course.setCourseName(rs.getString("course_name"));
				
				courses.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (null != statement)
					statement.close();
				
				if (null != connection)
					connection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return courses;
	}

	@Override
	public Course getById(Integer id) {
		Connection connection = null;
		Statement statement = null;
		
		// filtering user on basis of provided email
		String query = "SELECT * FROM course WHERE course_id = " + id;
		
		ArrayList<Course> courses = new ArrayList<>();
		
		try {
			
			connection = CreateDatabaseConnection.createConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
						
			while(rs.next()) {
				Course course = new Course();
				
				course.setCourseId(rs.getString("course_id"));
				course.setCourseCode(rs.getString("course_code"));
				course.setCourseName(rs.getString("course_name"));
				
				courses.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (null != statement)
					statement.close();
				
				if (null != connection)
					connection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return courses.get(0);
	}

}

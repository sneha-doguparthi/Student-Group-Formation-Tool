package com.asdc.group6.CourseAdmin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.asdc.group6.DBConnection.CreateDatabaseConnection;
import com.asdc.group6.Models.CourseAssociation;

@Component
public class CourseAssociationDAOImpl implements CourseAssociationDAO {

	@Override
	public ArrayList<Integer> getUserID(Integer courseId) {
		
		Connection connection = null;
		Statement statement = null;
		ArrayList<Integer> userIds = new ArrayList<>();
		
		try {
			
			connection = CreateDatabaseConnection.createConnection();
			statement = connection.createStatement();
		
			String query = "SELECT user_id FROM course_association WHERE course_id = '" + courseId + "'";
			ResultSet rs = statement.executeQuery(query);
						
			while(rs.next()) {
				int userId;
				userId = rs.getInt("user_id");
				userIds.add(userId);
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
	
		return userIds;
	}

	
	@Override
	public boolean addByUserID(ArrayList<Integer> userIds, Integer courseId) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		int listSize = userIds.size();
		
		try {
			
			connection = CreateDatabaseConnection.createConnection();
			
			for(int i=0; i<listSize; i++) {
				String reqQuery = "INSERT INTO course_association (user_id, course_id, role_id) values(?,?,?);";
				statement = connection.prepareStatement(reqQuery);
				statement.setInt(1, userIds.get(i));
				statement.setInt(2, courseId);
				statement.setInt(3, 2);
				statement.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				
				if (connection != null)
					connection.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return true;
	}
	
	
}

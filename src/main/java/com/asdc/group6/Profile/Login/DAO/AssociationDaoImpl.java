package com.asdc.group6.Profile.Login.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.stereotype.Component;
import com.asdc.group6.DBConnection.CreateDatabaseConnection;
import com.asdc.group6.Models.Association;

@Component
public class AssociationDaoImpl implements AssociationDao {

	@Override
	public Boolean insert(Association association) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = CreateDatabaseConnection.createConnection();

			String insertQuery = "INSERT INTO course_association (user_id,course_id,role_id) values(?,?,?);";
			statement = connection.prepareStatement(insertQuery);
			statement.setInt(1, association.getUserId());
			statement.setInt(2, association.getCourseId());
			statement.setString(3, association.getRoleId());
			
			statement.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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
	}

	@Override
	public ArrayList<Association> getByUserId(Integer userId) {
		
		Connection connection = null;
		Statement statement = null;
		
		// filtering user on basis of provided email
		String query = "SELECT * FROM course_association WHERE user_id = " + userId;
		
		ArrayList<Association> list = new ArrayList<>();
		
		try {
			
			connection = CreateDatabaseConnection.createConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
						
			while(rs.next()) {
				Association association = new Association();
				
				association.setRegistrationId(rs.getInt("registration_id"));
				association.setUserId(rs.getInt("user_id"));
				association.setCourseId(rs.getInt("course_id"));
				association.setRoleId(rs.getString("role_id"));
				
				list.add(association);
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
	
		return list;
	}
}

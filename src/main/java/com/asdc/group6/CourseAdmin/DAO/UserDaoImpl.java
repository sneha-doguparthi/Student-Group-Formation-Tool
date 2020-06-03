package com.asdc.group6.CourseAdmin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.asdc.group6.DBConnection.CreateDatabaseConnection;
import com.asdc.group6.Models.User;

@Component
public class UserDaoImpl implements UserDao {

	@Override
	public ArrayList<User> getAll() {
		
		Connection connection = null;
		Statement statement = null;
		String query = "SELECT * FROM user";
		
		ArrayList<User> users = new ArrayList<>();
		
		try {
			
			connection = CreateDatabaseConnection.createConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
						
			while(rs.next()) {
				User user = new User();
				
				user.setUserId(rs.getInt("user_id"));
				user.setBannerId(rs.getString("banner_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUserType(rs.getString("user_type"));
				
				users.add(user);
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
	
		return users;
	}

	@Override
	public ArrayList<User> getByEmail(String email) {
		
		Connection connection = null;
		Statement statement = null;
		
		// filtering user on basis of provided email
		String query = "SELECT * FROM user WHERE email = '" + email + "'";
		
		ArrayList<User> users = new ArrayList<>();
		
		try {
			
			connection = CreateDatabaseConnection.createConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
						
			while(rs.next()) {
				User user = new User();
				
				user.setUserId(rs.getInt("user_id"));
				user.setBannerId(rs.getString("banner_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUserType(rs.getString("user_type"));
				
				users.add(user);
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
	
		return users;

	}

	@Override
	public Boolean update(User user) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = CreateDatabaseConnection.createConnection();

			String insertQuery = "UPDATE user SET banner_id = ?, first_name = ?, last_name = ?, email = ?,"
					+ " password = ?, user_type = ? WHERE user_id = ?";
			
			statement = connection.prepareStatement(insertQuery);
			statement.setString(1, user.getBannerId());
			statement.setString(2, user.getFirstName());
			statement.setString(3, user.getLastName());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getUserType());
			statement.setInt(7, user.getUserId());
			
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
}

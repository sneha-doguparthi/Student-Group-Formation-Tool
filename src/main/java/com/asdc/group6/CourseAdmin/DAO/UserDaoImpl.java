package com.asdc.group6.CourseAdmin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import com.asdc.group6.DBConnection.DatabaseConnection;
import com.asdc.group6.Models.Student;
import com.asdc.group6.Models.User;

@Component
public class UserDAOImpl implements UserDAO {

	
	@Override
	public ArrayList<User> getUserByUserID(ArrayList<Integer> userIds) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs;
		ArrayList<User> users = new ArrayList<>();
		int listSize = userIds.size();
		
		try {
			
			connection = DatabaseConnection.createConnection();
			
			for(int i=0; i<listSize; i++) {
				String reqQuery = "SELECT * FROM user WHERE user_id = '" + userIds.get(i) + "'";
				statement = connection.prepareStatement(reqQuery);
				rs = statement.executeQuery(reqQuery);
							
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
	public ArrayList<User> getAll() {
		
		Connection connection = null;
		Statement statement = null;
		ArrayList<User> users = new ArrayList<>();
		
		try {
			connection = DatabaseConnection.createConnection();
			statement = connection.createStatement();
		
			String query = "SELECT * FROM user";
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
	public ArrayList<Integer> getUserID(List<Student> students) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs;
		int listSize = students.size();
		ArrayList<Integer> userIds = new ArrayList<>();
		int userId = 0;
		
		try {
			connection = DatabaseConnection.createConnection();
			
			for(int i=0; i<listSize; i++) {
			
				String reqQuery = "SELECT user_id FROM user WHERE banner_id=?";
				statement = connection.prepareStatement(reqQuery);
				statement.setString(1, students.get(i).getbId());
				
				rs = statement.executeQuery();
				
				System.out.println(i);
				
				if (rs.next()) userId = rs.getInt("user_id");
				userIds.add(userId);
				
				System.out.println(i);
		
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
	public boolean addUser(List<Student> student) {
	
		Connection connection = null;
		PreparedStatement statement = null;
		
		int listSize = student.size();
		
		try {
			connection = DatabaseConnection.createConnection();

			for(int i=0; i<listSize; i++) {
				
				String password = RandomStringUtils.random(10, true, true);
				
				String reqQuery = "INSERT INTO user (banner_id, first_name, last_name, email, password, user_type) "
									+ "values(?, ?, ?, ?, ?, ?);";
				statement = connection.prepareStatement(reqQuery);
				statement.setString(1, student.get(i).getbId());
				statement.setString(2, student.get(i).getFirstName());
				statement.setString(3, student.get(i).getLastName());
				statement.setString(4, student.get(i).getEmail());
				statement.setString(5, password);
				statement.setString(6, "S");
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
	
	
	
	@Override
	public ArrayList<String> getPassword(List<Student> students) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs;
		int listSize = students.size();
		ArrayList<String> passwords = new ArrayList<>();
		String password = "";
		
		try {
			connection = DatabaseConnection.createConnection();
			
			for(int i=0; i<listSize; i++) {
			
				String reqQuery = "SELECT password FROM user WHERE banner_id=?";
				statement = connection.prepareStatement(reqQuery);
				statement.setString(1, students.get(i).getbId());
				
				rs = statement.executeQuery();
				
				if (rs.next()) password = rs.getString("password");
				passwords.add(password);
				
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
	
		return passwords;
	}
	
	
	
//	@Override
//	public ArrayList<User> getByUserID(ArrayList<Integer> userIds) {
//		
//		Connection connection = null;
//		PreparedStatement statement = null;
//		ResultSet rs;
//		ArrayList<User> users = new ArrayList<>();
//		int listSize = userIds.size();
//		
//		try {
//			
//			connection = DatabaseConnection.createConnection();
//			
//			for(int i=0; i<listSize; i++) {
//				String reqQuery = "SELECT * FROM user WHERE user_id = '" + userIds.get(i) + "'";
//				statement = connection.prepareStatement(reqQuery);
//				rs = statement.executeQuery(reqQuery);
//							
//				while(rs.next()) {
//					User user = new User();
//					user.setUserId(rs.getInt("user_id"));
//					user.setBannerId(rs.getString("banner_id"));
//					user.setFirstName(rs.getString("first_name"));
//					user.setLastName(rs.getString("last_name"));
//					user.setEmail(rs.getString("email"));
//					user.setPassword(rs.getString("password"));
//					user.setUserType(rs.getString("user_type"));
//					users.add(user);
//				}
//			}
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (null != statement)
//					statement.close();
//				
//				if (null != connection)
//					connection.close();
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	
//		return users;
//	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public void associateUserToCourse(List<Student> newToCourseList) {
//	
//		Connection connection = null;
//		PreparedStatement statement1 = null;
//		PreparedStatement statement2 = null;
//		ResultSet rs = null;
//		
//		int listSize = newToCourseList.size();
//		
//		try {
//			connection = DatabaseConnection.createConnection();
//
//			for(int i=0; i<listSize; i++) {
//				
//				String reqQuery = "SELECT user_id FROM user WHERE banner_id=?";
//				statement1 = connection.prepareStatement(reqQuery);
//				statement1.setString(1, newToCourseList.get(i).getbId());
//				
//				rs = statement1.executeQuery();
//				
//				reqQuery = "INSERT INTO course_association (user_id, course_id, role_id) values(?,?,?);";
//				statement2 = connection.prepareStatement(reqQuery);
//				if (rs.next()) statement2.setInt(1, rs.getInt("user_id"));
//				statement2.setInt(2, 2);
//				statement2.setInt(3, 2);
//				statement2.executeUpdate();
//			
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (statement1 != null)
//					statement1.close();
//				if (rs != null)
//					rs.close();
//				if (statement2 != null)
//					statement2.close();
//				if (connection != null)
//					connection.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//	}

}

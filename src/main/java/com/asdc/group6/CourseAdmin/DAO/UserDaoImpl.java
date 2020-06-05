package com.asdc.group6.CourseAdmin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import com.asdc.group6.DBConnection.CreateDatabaseConnection;
import com.asdc.group6.Models.Student;
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

			while (rs.next()) {
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

			while (rs.next()) {
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

	@Override
	public ArrayList<User> getUserByUserID(ArrayList<Integer> userIds) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs;
		ArrayList<User> users = new ArrayList<>();
		int listSize = userIds.size();

		try {

			connection = CreateDatabaseConnection.createConnection();

			for (int i = 0; i < listSize; i++) {
				String reqQuery = "SELECT * FROM user WHERE user_id = '" + userIds.get(i) + "'";
				statement = connection.prepareStatement(reqQuery);
				rs = statement.executeQuery(reqQuery);

				while (rs.next()) {
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
	public ArrayList<Integer> getUserID(List<Student> students) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs;
		int listSize = students.size();
		ArrayList<Integer> userIds = new ArrayList<>();
		int userId = 0;

		try {
			connection = CreateDatabaseConnection.createConnection();

			for (int i = 0; i < listSize; i++) {

				String reqQuery = "SELECT user_id FROM user WHERE banner_id=?";
				statement = connection.prepareStatement(reqQuery);
				statement.setString(1, students.get(i).getbId());

				rs = statement.executeQuery();

				System.out.println(i);

				if (rs.next())
					userId = rs.getInt("user_id");
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
			connection = CreateDatabaseConnection.createConnection();

			for (int i = 0; i < listSize; i++) {

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
			connection = CreateDatabaseConnection.createConnection();

			for (int i = 0; i < listSize; i++) {

				String reqQuery = "SELECT password FROM user WHERE banner_id=?";
				statement = connection.prepareStatement(reqQuery);
				statement.setString(1, students.get(i).getbId());

				rs = statement.executeQuery();

				if (rs.next())
					password = rs.getString("password");
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
}

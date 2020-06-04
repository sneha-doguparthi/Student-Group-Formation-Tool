package com.asdc.group6.Profile.Registration.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.asdc.group6.DBConnection.CreateDatabaseConnection;
import com.asdc.group6.Models.User;
import com.asdc.group6.Profile.Login.DAO.UserLoginDao;
import com.asdc.group6.Profile.Login.DAO.UserLoginDaoImpl;

public class RegistrationDaoImpl implements RegistrationDao {

	public boolean registerUser(User user) {
		Connection connection = null;
		boolean isRegistered = false;
		PreparedStatement statement = null;
		try {
			String query = "INSERT INTO user(banner_id,first_name,last_name,email,password,user_type) VALUES(?,?,?,?,?,?);";
			connection = CreateDatabaseConnection.createConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, user.getBannerId());
			statement.setString(2, user.getFirstName());
			statement.setString(3, user.getLastName());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getPassword());
			statement.setString(6, "G");
			UserLoginDao userLoginDao = new UserLoginDaoImpl();
			if (userLoginDao.checkAccess(user) == false) {
				int result = statement.executeUpdate();
				isRegistered = result > 0 ? true : false;
			}
		} catch (SQLException exception) {
			isRegistered = false;
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
		return isRegistered;
	}
}

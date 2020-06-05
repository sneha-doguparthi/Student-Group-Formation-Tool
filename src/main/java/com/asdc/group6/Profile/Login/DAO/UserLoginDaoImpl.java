package com.asdc.group6.Profile.Login.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.asdc.group6.DBConnection.CreateDatabaseConnection;
import com.asdc.group6.Models.User;

public class UserLoginDaoImpl implements UserLoginDao {

	public boolean checkAccess(User user) {
		PreparedStatement statement = null;
		Connection connection = null;
		boolean isUser = false;
		try {
			String query = "SELECT user_type, user_id FROM user WHERE email=? AND password=?;";
			connection = CreateDatabaseConnection.createConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			ResultSet rs = statement.executeQuery();
			if (rs.next() == false)
				return isUser;
			else {
				user.setUserId(rs.getInt("user_id"));
				user.setUserType(rs.getString("user_type"));
				isUser = true;
				return isUser;
			}
		} catch (SQLException e) {
			return isUser;
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
	}
}

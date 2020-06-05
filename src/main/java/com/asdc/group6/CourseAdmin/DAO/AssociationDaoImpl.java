package com.asdc.group6.CourseAdmin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}

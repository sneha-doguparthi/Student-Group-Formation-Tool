package com.asdc.group6.CourseAdmin.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.asdc.group6.DBConnection.CreateDatabaseConnection;
import com.asdc.group6.Models.Role;

@Component
public class RoleDaoImpl implements RoleDao {

	@Override
	public ArrayList<Role> findByName(String name) {
		
		Connection connection = null;
		Statement statement = null;
		
		// filtering user on basis of provided email
		String query = "SELECT * FROM role WHERE role_name = '" + name + "'";
		
		ArrayList<Role> roles = new ArrayList<>();
		
		try {
			
			connection = CreateDatabaseConnection.createConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
						
			while(rs.next()) {
				Role role = new Role();
				
				role.setRoleId(rs.getString("role_id"));
				role.setRoleName(rs.getString("role_name"));
				
				roles.add(role);
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
	
		return roles;
	}

}

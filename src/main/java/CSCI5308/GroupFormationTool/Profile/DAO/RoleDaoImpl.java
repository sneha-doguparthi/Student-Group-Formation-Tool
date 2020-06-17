package CSCI5308.GroupFormationTool.Profile.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.DBConnection.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.Model.Role;

public class RoleDaoImpl implements RoleDao {

	private Logger logger = LogManager.getLogger(RoleDaoImpl.class);
	
	@Override
	public ArrayList<Role> findByName(String name) {

		Connection connection = null;
		Statement statement = null;

		// filtering user on basis of provided email
		String query = "SELECT * FROM role WHERE role_name = '" + name + "'";

		ArrayList<Role> roles = new ArrayList<>();

		try {

			connection = CreateDatabaseConnection.instance().createConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				Role role = new Role();

				role.setRoleId(rs.getInt("role_id"));
				role.setRoleName(rs.getString("role_name"));

				roles.add(role);
			}
		} catch (SQLException e) {
			logger.error("Exception occured finding user role by role name: ", e);
		} finally {
			try {
				if (null != statement) {
					statement.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (SQLException e) {
				logger.error("Exception occured while closing connection/statement", e);
			}
		}

		return roles;
	}

}

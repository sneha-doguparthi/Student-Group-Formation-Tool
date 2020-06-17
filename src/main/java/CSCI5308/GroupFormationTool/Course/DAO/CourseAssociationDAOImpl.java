package CSCI5308.GroupFormationTool.Course.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.DBConnection.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.Model.CourseAssociation;

public class CourseAssociationDAOImpl implements CourseAssociationDAO {
	
	private Logger logger = LogManager.getLogger(CourseAssociationDAOImpl.class);
	
	@Override
	public ArrayList<Integer> getUserID(Integer courseId) {

		Connection connection = null;
		Statement statement = null;
		ArrayList<Integer> userIds = new ArrayList<>();

		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			statement = connection.createStatement();

			String query = "SELECT user_id FROM course_association WHERE course_id = '" + courseId + "'";
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				int userId;
				userId = rs.getInt("user_id");
				userIds.add(userId);
			}

		} catch (SQLException e) {
			logger.error("Exception occured while getting the user id: ", e);
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

		return userIds;
	}

	@Override
	public boolean addByUserID(ArrayList<Integer> userIds, Integer courseId) {

		Connection connection = null;
		PreparedStatement statement = null;
		int listSize = userIds.size();

		try {

			connection = CreateDatabaseConnection.instance().createConnection();

			for (int i = 0; i < listSize; i++) {
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
				if (null != statement) {
					statement.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return true;
	}

	@Override
	public Boolean insert(CourseAssociation association) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = CreateDatabaseConnection.instance().createConnection();

			String insertQuery = "INSERT INTO course_association (user_id,course_id,role_id) values(?,?,?);";
			statement = connection.prepareStatement(insertQuery);
			statement.setInt(1, association.getUserId());
			statement.setInt(2, association.getCourseId());
			statement.setString(3, String.valueOf(association.getRoleId()));

			statement.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (null != statement) {
					statement.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<CourseAssociation> getByUserId(Integer userId) {

		Connection connection = null;
		Statement statement = null;

		// filtering user on basis of provided email
		String query = "SELECT * FROM course_association WHERE user_id = " + userId;

		ArrayList<CourseAssociation> list = new ArrayList<>();

		try {

			connection = CreateDatabaseConnection.instance().createConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				CourseAssociation association = new CourseAssociation();

				association.setRegistrationId(rs.getInt("registration_id"));
				association.setUserId(rs.getInt("user_id"));
				association.setCourseId(rs.getInt("course_id"));
				association.setRoleId(Integer.valueOf(rs.getString("role_id")));

				list.add(association);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != statement) {
					statement.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;
	}
}

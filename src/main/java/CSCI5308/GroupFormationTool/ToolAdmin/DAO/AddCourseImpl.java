package CSCI5308.GroupFormationTool.ToolAdmin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.DBUtil.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.DBUtil.SqlQueryUtil;
import CSCI5308.GroupFormationTool.Utilities.ApplicationConstants;

public class AddCourseImpl implements IAddCourse {

	private Logger logger = LogManager.getLogger(AddCourseImpl.class);

	@Override
	public String addNewCourse(ICourse course) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			if (checkIfCourseExists(course)) {
				return ApplicationConstants.COURSE_ALREADY_EXISTS;
			}
			connection = CreateDatabaseConnection.instance().createConnection();
			String insertQuery = SqlQueryUtil.instance().getQueryByKey("addCourse");
			statement = connection.prepareStatement(insertQuery);
			statement.setString(1, course.getCourseCode());
			statement.setString(2, course.getCourseName());
			int result = statement.executeUpdate();
			if (result > 0) {
				return ApplicationConstants.COURSE_ADDED;
			}
		} catch (SQLException e) {
			logger.error("Exception occured while adding new course", e);
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
		return ApplicationConstants.COURSE_ADD_FAILED;
	}

	@Override
	public boolean checkIfCourseExists(ICourse course) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			String selectQuery = SqlQueryUtil.instance().getQueryByKey("existingCourse");
			statement = connection.prepareStatement(selectQuery);
			statement.setString(1, course.getCourseCode());
			ResultSet resultSet = statement.executeQuery();
			int size = 0;
			while (resultSet.next()) {
				size++;
			}
			if (size > 0)
				return true;
		} catch (SQLException e) {
			logger.error("Exception occured while checking if course exists", e);
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
		return false;
	}
}

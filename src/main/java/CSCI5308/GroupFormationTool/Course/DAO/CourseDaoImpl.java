package CSCI5308.GroupFormationTool.Course.DAO;

import java.sql.*;
import java.util.ArrayList;

import CSCI5308.GroupFormationTool.DBUtil.SqlQueryUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.DBUtil.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.Model.Course;

public class CourseDaoImpl implements CourseDao {

	private Logger logger = LogManager.getLogger(CourseDaoImpl.class);

	@Override
	public ArrayList<Course> getAll() {

		Connection connection = null;
		Statement statement = null;
		String query = SqlQueryUtil.instance().getQueryByKey("courseDetails");
		ArrayList<Course> courses = new ArrayList<>();

		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Course course = new Course();
				course.setCourseId(rs.getInt("course_id"));
				course.setCourseCode(rs.getString("course_code"));
				course.setCourseName(rs.getString("course_name"));
				courses.add(course);
			}
		} catch (SQLException e) {
			logger.error("Exception occured while getting all users: ", e);
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

		return courses;
	}

	@Override
	public Course getById(Integer id) {

		Connection connection = null;
		PreparedStatement statement = null;
		String courseById = SqlQueryUtil.instance().getQueryByKey("courseDetailsById");
		ArrayList<Course> courses = new ArrayList<>();

		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			statement = connection.prepareStatement(courseById);
			statement.setInt(1,id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Course course = new Course();
				course.setCourseId(rs.getInt("course_id"));
				course.setCourseCode(rs.getString("course_code"));
				course.setCourseName(rs.getString("course_name"));
				courses.add(course);
			}
		} catch (SQLException e) {
			logger.error("Exception occured while getting the user by id: ", e);
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

		return courses.get(0);
	}
}

package CSCI5308.GroupFormationTool.Course.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.Course.CourseFactory;
import CSCI5308.GroupFormationTool.Course.CourseObjectFactory;
import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.DBUtil.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.DBUtil.SqlQueryUtil;

public class CourseDaoImpl implements ICourseDao {

	private Logger logger = LogManager.getLogger(CourseDaoImpl.class);

	@Override
	public ArrayList<ICourse> getAll() {

		Connection connection = null;
		Statement statement = null;
		String query = SqlQueryUtil.instance().getQueryByKey("courseDetails");
		ArrayList<ICourse> courses = new ArrayList<>();

		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				ICourse course = CourseFactory.courseObject(new CourseObjectFactory());
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
	public ICourse getById(Integer id) {

		Connection connection = null;

		PreparedStatement statement = null;
		String courseById = SqlQueryUtil.instance().getQueryByKey("courseDetailsById");
		ArrayList<ICourse> courses = new ArrayList<>();

		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			statement = connection.prepareStatement(courseById);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				ICourse course = CourseFactory.courseObject(new CourseObjectFactory());
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

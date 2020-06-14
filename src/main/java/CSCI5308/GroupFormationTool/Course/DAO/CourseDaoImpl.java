package CSCI5308.GroupFormationTool.Course.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import CSCI5308.GroupFormationTool.DBConnection.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.Model.Course;

public class CourseDaoImpl implements CourseDao {

	@Override
	public ArrayList<Course> getAll() {

		Connection connection = null;
		Statement statement = null;
		String query = "SELECT * FROM course";

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

		return courses;
	}

	@Override
	public Course getById(Integer id) {
		Connection connection = null;
		Statement statement = null;

		// filtering user on basis of provided email
		String query = "SELECT * FROM course WHERE course_id = " + id;

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

		return courses.get(0);
	}

}

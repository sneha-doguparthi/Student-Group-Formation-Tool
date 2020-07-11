package CSCI5308.GroupFormationTool.ToolAdmin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.DBUtil.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.DBUtil.SqlQueryUtil;

public class DeleteCourseImpl implements IDeleteCourse {

	private Logger logger = LogManager.getLogger(DeleteCourseImpl.class);

	@Override
	public ArrayList<String> deleteCourse(ArrayList<String> courseToDelete) {

		Connection connection = null;
		PreparedStatement statement = null;
		ArrayList<String> resultList = new ArrayList<>();

		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			String deleteQueryCourseAssociation = "";
			String deleteQueryCourse = "";
			for (int i = 0; i < courseToDelete.size(); i++) {
				deleteQueryCourseAssociation = SqlQueryUtil.instance().getQueryByKey("deleteCourse");
				statement = connection.prepareStatement(deleteQueryCourseAssociation);
				statement.setString(1, courseToDelete.get(i));
				statement.executeUpdate();
				statement.close();
				deleteQueryCourse = "DELETE FROM course WHERE course_code = ?";
				statement = connection.prepareStatement(deleteQueryCourse);
				statement.setString(1, courseToDelete.get(i));
				int result = statement.executeUpdate();
				if (result > 0)
					resultList.add(courseToDelete.get(i) + " deleted successfully!");
				else
					resultList.add(courseToDelete.get(i) + " failed to delete!");
			}
		} catch (SQLException e) {
			logger.error("Exception occured while deleteing the course(s)", e);
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

		return resultList;
	}

}
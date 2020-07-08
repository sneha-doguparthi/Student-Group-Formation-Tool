package CSCI5308.GroupFormationTool.Course.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.DBUtil.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.Model.Student;
import CSCI5308.GroupFormationTool.Model.User;

public class GetStudentListServiceImpl implements GetStudentListService {

	private Logger logger = LogManager.getLogger(GetStudentListServiceImpl.class);

	@Override
	public List<Student> getNewToCourseStudentList(List<Student> studentsFromCsv, ArrayList<User> specificUserList) {

		List<Student> students = new ArrayList<Student>(studentsFromCsv);
		List<User> users = new ArrayList<User>(specificUserList);
		int studentsSize = students.size();
		int usersSize = users.size();

		for (int i = 0; i < usersSize; i++) {
			for (int j = 0; j < studentsSize; j++) {
				if (students.get(j).getbId().equals(users.get(i).getBannerId())) {
					students.remove(j);
					studentsSize--;
					break;
				}
			}
		}

		return students;
	}

	@Override
	public List<Student> getNewToPortalStudentList(List<Student> newToCourseList, ArrayList<User> allUserList) {

		List<Student> students = new ArrayList<Student>(newToCourseList);
		List<User> users = new ArrayList<User>(allUserList);
		int studentsSize = students.size();
		int usersSize = users.size();
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			for (int i = 0; i < usersSize; i++) {
				for (int j = 0; j < studentsSize; j++) {
					if (students.get(j).getbId().equals(users.get(i).getBannerId())) {
						String reqQuery = "UPDATE user SET user_type='S' WHERE banner_id=?";
						statement = connection.prepareStatement(reqQuery);
						statement.setString(1, users.get(i).getBannerId());
						statement.executeUpdate();
						students.remove(j);
						studentsSize--;
						break;
					}
				}
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

		return students;
	}
}

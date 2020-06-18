package CSCI5308.GroupFormationTool.QuestionManager.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import CSCI5308.GroupFormationTool.DBConnection.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.Model.Question;
import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.Profile.DAO.UserDao;
import CSCI5308.GroupFormationTool.Profile.DAO.UserDaoImpl;

public class FetchQuestionDAOImpl implements FetchQuestionDAO {

	@Override
	public ArrayList<Question> getQuestionByUserId() {
		Connection connection = null;
		Statement statement = null;
		ArrayList<Question> questions = new ArrayList<>();

		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			statement = connection.createStatement();

			String query = "SELECT * FROM question WHERE user_id=" + getUserId();
			ResultSet rs = statement.executeQuery(query);

			int i = 1;
			while (rs.next()) {
				Question question = new Question();
				question.setQuestionNo(i++);
				question.setQuestionId(rs.getInt("question_id"));
				question.setQuestionTitle(rs.getString("question_title"));
				question.setQuestionText(rs.getString("question_text"));
				question.setQuestionType(rs.getString("question_type"));
				question.setQuestionDate(rs.getString("created_date"));
				questions.add(question);
			}
		} catch (SQLException e) {
			System.out.println("Exception occured while getting all the questions: \n" + e);
		} finally {
			try {
				if (null != statement) {
					statement.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("Exception occured while closing connection/statement: \n" + e);
			}
		}

		return questions;
	}
	
	public int getUserId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDao userDao = new UserDaoImpl();
		ArrayList<User> list = userDao.getByEmail(authentication.getName());
		return list.get(0).getUserId();
	}
	
}

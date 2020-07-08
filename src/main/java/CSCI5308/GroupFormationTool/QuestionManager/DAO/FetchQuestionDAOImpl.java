package CSCI5308.GroupFormationTool.QuestionManager.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.DBUtil.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.Model.Question;
import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.Profile.DAO.UserDao;

public class FetchQuestionDAOImpl implements FetchQuestionDAO {

	@Override
	public ArrayList<Question> getQuestionByUserId() {

		Connection connection = null;
		Statement statement = null;
		ArrayList<Question> questions = new ArrayList<>();
		Logger logger = LogManager.getLogger(FetchQuestionDAOImpl.class);

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
			logger.error("Exception occurred while getting all the questions: ", e);
		} finally {
			try {
				if (null != statement) {
					statement.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (SQLException e) {
				logger.error("Exception occurred while closing connection/statement: ", e);
			}
		}

		return questions;
	}

	public int getUserId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDao userDao = SystemConfig.instance().getUserDao();

		ArrayList<User> list = userDao.getByEmail(authentication.getName());

		return list.get(0).getUserId();
	}

}

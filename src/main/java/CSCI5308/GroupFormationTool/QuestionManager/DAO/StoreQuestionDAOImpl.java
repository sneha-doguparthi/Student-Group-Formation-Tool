package CSCI5308.GroupFormationTool.QuestionManager.DAO;

import CSCI5308.GroupFormationTool.DBConnection.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.Model.Question;
import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.Profile.DAO.UserDao;
import CSCI5308.GroupFormationTool.SystemConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.sql.*;
import java.util.ArrayList;

public class StoreQuestionDAOImpl implements StoreQuestionDAO {

	private Logger logger = LogManager.getLogger(StoreQuestionDAOImpl.class);
	Connection connection;

	@Override
	public int saveQuestionDetails(Question question) {

		int questionId = -1;
		PreparedStatement statement = null;

		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			String insertQuery = "INSERT INTO question (question_title,question_text,question_type, user_id) values(?,?,?,?);";
			statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, question.getQuestionTitle());
			statement.setString(2, question.getQuestionText());
			statement.setString(3, question.getQuestionType());
			statement.setInt(4, getUserId());
			statement.executeUpdate();
			ResultSet resultSet = statement.getGeneratedKeys();
			resultSet.next();
			if (null != resultSet) {
				questionId = resultSet.getInt(1);
				logger.info("Question id from database: " + questionId);
			}
		} catch (SQLException e) {
			logger.error("Exception occured while saving question and answers", e);
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

		return questionId;
	}

	private int getUserId() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDao userDao = SystemConfig.instance().getUserDao();

		ArrayList<User> list = userDao.getByEmail(authentication.getName());

		return list.get(0).getUserId();
	}

}

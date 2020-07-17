package CSCI5308.GroupFormationTool.QuestionManager.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.DBUtil.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.DBUtil.SqlQueryUtil;
import CSCI5308.GroupFormationTool.Profile.Service.ProfileServiceFactory;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;

public class StoreQuestionDAOImpl implements IStoreQuestionDAO {

	private Logger logger = LogManager.getLogger(StoreQuestionDAOImpl.class);
	Connection connection;

	@Override
	public int saveQuestionDetails(IQuestion question) {

		int questionId = -1;
		PreparedStatement statement = null;

		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			String insertQuery = SqlQueryUtil.instance().getQueryByKey("createQuestion");
			statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, question.getQuestionTitle());
			statement.setString(2, question.getQuestionText());
			statement.setString(3, question.getQuestionType());
			int userId = ProfileServiceFactory.instance().loginService().getUserId();
			statement.setInt(4, userId);
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
}

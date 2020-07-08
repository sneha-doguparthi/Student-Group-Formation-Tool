package CSCI5308.GroupFormationTool.QuestionManager.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.DBUtil.CreateDatabaseConnection;

public class DeleteQuestionDAOImpl implements DeleteQuestionDAO {

	@Override
	public boolean deleteQuestionByQuestionId(Integer questionId) {

		Connection connection = null;
		Statement statement = null;
		Logger logger = LogManager.getLogger(DeleteQuestionDAOImpl.class);

		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			statement = connection.createStatement();
			deleteQuestionOption(questionId);
			String query = "DELETE FROM question WHERE question_id=" + questionId;
			statement.execute(query);
		} catch (SQLException exception) {
			logger.error("SQL Exception in method delete question", exception);
		} finally {
			try {
				if (null != statement) {
					statement.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (SQLException exception) {
				logger.error("Connection close Exception in method delete question", exception);
			}
		}

		return true;
	}

	@Override
	public boolean deleteQuestionOption(int questionId) {

		Connection connection = null;
		Statement statement = null;
		Logger logger = LogManager.getLogger(DeleteQuestionDAOImpl.class);

		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			statement = connection.createStatement();
			String query = "DELETE FROM multiple_choice_ques_option WHERE question_id=" + questionId;
			statement.execute(query);
		} catch (SQLException exception) {
			logger.error("SQL Exception in method delete question option", exception);
		} finally {
			try {
				if (null != statement) {
					statement.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (SQLException exception) {
				logger.error("Connection close Exception in method delete question option", exception);
			}
		}

		return true;
	}

}

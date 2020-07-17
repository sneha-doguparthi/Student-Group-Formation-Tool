package CSCI5308.GroupFormationTool.QuestionManager.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.DBUtil.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.DBUtil.SqlQueryUtil;
import CSCI5308.GroupFormationTool.Model.Answer;
import CSCI5308.GroupFormationTool.Utilities.ApplicationConstants;

public class StoreMcqOptionsDAOImpl implements IStoreMcqOptionsDAO {

	private Logger logger = LogManager.getLogger(StoreMcqOptionsDAOImpl.class);
	Connection connection;

	@Override
	public String saveMcqOptionsForQuestion(int questionId, ArrayList<Answer> answerList) {

		PreparedStatement statement = null;
		int count = 0;
		String queryResult = ApplicationConstants.FAILED_QUESTION_ANSWERS_INSERTION;

		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			for (Answer answer : answerList) {
				String insertQuery = SqlQueryUtil.instance().getQueryByKey("insertQuestionOptions");
				statement = connection.prepareStatement(insertQuery);
				statement.setString(1, answer.getAnswerText());
				statement.setString(2, answer.getStoredAs());
				statement.setInt(3, questionId);
				int result = statement.executeUpdate();
				if (result > 0)
					count++;
			}
		} catch (SQLException e) {
			logger.error("Exception occured while saving answers for questionId: " + questionId, e);
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
		if (count == answerList.size()) {
			queryResult = ApplicationConstants.QUESTION_ANSWERS_ADDED;
		}

		return queryResult;
	}

}

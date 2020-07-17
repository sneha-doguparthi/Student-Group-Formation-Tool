package CSCI5308.GroupFormationTool.Course.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.DBUtil.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.DBUtil.SqlQueryUtil;
import CSCI5308.GroupFormationTool.Model.SurveyResponse;
import CSCI5308.GroupFormationTool.Utilities.ApplicationConstants;

public class CourseSurveyDaoImpl implements ICourseSurveyDao {

	private Logger logger = LogManager.getLogger(CourseSurveyDaoImpl.class);

	@Override
	public String storeSurveyResponse(ArrayList<SurveyResponse> surveyResponse) {
		Connection connection = null;
		PreparedStatement statement = null;
		int flag = 1;
		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			String insertQuery = SqlQueryUtil.instance().getQueryByKey("storeSurveyResponse");
			for (SurveyResponse response : surveyResponse) {
				statement = connection.prepareStatement(insertQuery);
				statement.setString(1, response.getAnswer());
				statement.setInt(2, response.getQuestionId());
				statement.setInt(3, response.getCourseId());
				statement.setInt(4, response.getUserId());
				int result = statement.executeUpdate();
				if (result < 0) {
					flag = -1;
					break;
				}
			}
		} catch (SQLException e) {
			logger.error("Exception occured while adding new course", e);
			flag = -1;
			return ApplicationConstants.DB_NOT_ACCESSIBLE;
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
		if (flag == -1) {
			logger.info("Store survey response: " + ApplicationConstants.FAILED_TO_SAVE_RESPONSE);
			return ApplicationConstants.FAILED_TO_SAVE_RESPONSE;
		} else {
			logger.info("Store survey response: " + ApplicationConstants.SURVEY_RESPONSE_SAVED);
			return ApplicationConstants.SURVEY_RESPONSE_SAVED;
		}
	}

	@Override
	public boolean checkIfSurveySubmitted(int courseId, int userId) {
		Connection connection = null;
		PreparedStatement statement = null;
		int i = 0;
		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			String selectQuery = SqlQueryUtil.instance().getQueryByKey("surveySubmissionStatus");
			statement = connection.prepareStatement(selectQuery);
			statement.setInt(1, courseId);
			statement.setInt(2, userId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				i++;
			}
		} catch (SQLException e) {
			i = 0;
			logger.error("Exception occured while fetching the course list: ", e);
		} finally {
			try {
				if (null != statement) {
					statement.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (SQLException e) {
				logger.error("Exception occured while closing connection/statement: ", e);
			}
		}
		if (i > 0) {
			logger.info("User has already submitted the survey.");
			return true;
		} else {
			logger.info("Survey pending for user.");
			return false;
		}
	}
}

package CSCI5308.GroupFormationTool.Survey.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.DBUtil.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.Survey.ISurvey;

public class SaveSurveyDAOImpl implements ISaveSurveyDAO {
	private Logger logger = LogManager.getLogger(SaveSurveyDAOImpl.class);

	public boolean saveSurveyQuestions(List<IQuestion> questions) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		int listSize = questions.size();
		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			for (int i = 0; i < listSize; i++) {
				String query1 = "SELECT * FROM survey_question_association WHERE course_id = ? AND question_id = ?";
				statement = connection.prepareStatement(query1);
				statement.setInt(1, questions.get(i).getCourseId());
				statement.setInt(2, questions.get(i).getQuestionId());
				rs = statement.executeQuery();
				if (!rs.next()) {
					String query = "INSERT INTO survey_question_association(course_id,question_id,criteria) values(?,?,?)";
					statement = connection.prepareStatement(query);
					statement.setInt(1, questions.get(i).getCourseId());
					statement.setInt(2, questions.get(i).getQuestionId());
					statement.setString(3, questions.get(i).getCriteria());
					statement.executeUpdate();
				}
				else {
					String query = "UPDATE survey_question_association SET criteria = ? WHERE course_id = ? AND question_id = ?";
					statement = connection.prepareStatement(query);
					statement.setString(1, questions.get(i).getCriteria());
					statement.setInt(2, questions.get(i).getCourseId());
					statement.setInt(3, questions.get(i).getQuestionId());
					statement.executeUpdate();
				}
			}
		} catch (SQLException e) {
			logger.error("Exception occurred while adding the user: ", e);
		} finally {
			try {
				if (null != statement) {
					statement.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (SQLException e) {
				logger.error("Exception occurred while closing connection/statement", e);
			}
		}
		return true;
	}

	public void saveSurveyDetails(ISurvey survey) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			String query1 = "SELECT * FROM instructor_survey_association WHERE course_id = ?";
			statement = connection.prepareStatement(query1);
			statement.setInt(1, survey.getCourseId());
			rs = statement.executeQuery();
			if (!rs.next()) {
				String query = "INSERT INTO instructor_survey_association(survey_status,course_id,group_size) values(?,?,?)";
				statement = connection.prepareStatement(query);
				statement.setString(1, "S");
				statement.setInt(2, survey.getCourseId());
				statement.setInt(3,survey.getGroupSize());
				statement.executeUpdate();
			}
			else {
				String query = "UPDATE instructor_survey_association SET group_size = ? WHERE course_id = ?";
				statement = connection.prepareStatement(query);
				statement.setInt(1, survey.getGroupSize());
				statement.setInt(2, survey.getCourseId());
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			logger.error("Exception occurred while adding the user: ", e);
		} finally {
			try {
				if (null != statement) {
					statement.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (SQLException e) {
				logger.error("Exception occurred while closing connection/statement", e);
			}
		}

	}

	public boolean publishSurvey(int course_id) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			String query = "UPDATE instructor_survey_association SET survey_status=\"A\" where course_id=" + course_id;
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException e) {
			logger.error("Exception occurred while adding the user: ", e);
		} finally {
			try {
				if (null != statement) {
					statement.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (SQLException e) {
				logger.error("Exception occurred while closing connection/statement", e);
			}
		}
		return true;
	}

	@Override
	public void deleteSurveyQuestion(int questionId, int courseId) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			String query1 = "SELECT * FROM survey_question_association WHERE course_id = ? AND question_id = ?";
			statement = connection.prepareStatement(query1);
			statement.setInt(1, courseId);
			statement.setInt(2, questionId);
			rs = statement.executeQuery();
			if (rs.next()) {
				String query = "DELETE FROM survey_question_association WHERE course_id = ? AND question_id = ?";
				statement = connection.prepareStatement(query);
				statement.setInt(1, courseId);
				statement.setInt(2, questionId);
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			logger.error("Exception occurred while adding the user: ", e);
		} finally {
			try {
				if (null != statement) {
					statement.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (SQLException e) {
				logger.error("Exception occurred while closing connection/statement", e);
			}
		}
	}

}

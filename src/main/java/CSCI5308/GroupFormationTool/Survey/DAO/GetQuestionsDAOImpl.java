package CSCI5308.GroupFormationTool.Survey.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.DBUtil.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.DBUtil.SqlQueryUtil;
import CSCI5308.GroupFormationTool.Profile.Service.ProfileServiceFactory;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionFactory;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionObjectFactory;

public class GetQuestionsDAOImpl implements IGetQuestionsDAO {
	Logger logger = LogManager.getLogger(GetQuestionsDAOImpl.class);

	public ArrayList<IQuestion> getQuestionByInstructorId() {
		Connection connection = null;
		PreparedStatement statement = null;
		ArrayList<IQuestion> questions = new ArrayList<>();
		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			String query = SqlQueryUtil.instance().getQueryByKey("getSurveyQuestionsForCourse");
			statement = connection.prepareStatement(query);
			int userId = ProfileServiceFactory.instance().loginService().getUserId();
			statement.setInt(1, userId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				IQuestion question = QuestionFactory.questionObject(new QuestionObjectFactory());
				question.setQuestionId(rs.getInt("question_id"));
				question.setQuestionTitle(rs.getString("question_title"));
				question.setQuestionText(rs.getString("question_text"));
				question.setQuestionType(rs.getString("question_type"));
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

	public IQuestion getQuestionById(int questionId) {
		IQuestion question = QuestionFactory.questionObject(new QuestionObjectFactory());
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			String query = SqlQueryUtil.instance().getQueryByKey("getQuestionById");
			statement = connection.prepareStatement(query);
			statement.setInt(1, questionId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				question.setQuestionId(rs.getInt("question_id"));
				question.setQuestionTitle(rs.getString("question_title"));
				question.setQuestionText(rs.getString("question_text"));
				question.setQuestionType(rs.getString("question_type"));
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
		return question;
	}

	public String getSurveyStatus(int courseId) {
		Connection connection = null;
		PreparedStatement statement = null;
		String status = "";
		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			String query = SqlQueryUtil.instance().getQueryByKey("getSurveyStatus");
			statement = connection.prepareStatement(query);
			statement.setInt(1, courseId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				status = rs.getString("course_id");
			}
		} catch (SQLException e) {
			logger.error("Exception occurred while getting survey status: ", e);
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
		return status;
	}
}

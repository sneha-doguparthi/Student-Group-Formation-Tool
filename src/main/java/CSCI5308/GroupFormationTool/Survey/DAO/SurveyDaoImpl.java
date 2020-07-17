package CSCI5308.GroupFormationTool.Survey.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.DBUtil.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.DBUtil.SqlQueryUtil;
import CSCI5308.GroupFormationTool.Model.Answer;
import CSCI5308.GroupFormationTool.Model.SurveyResponse;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionFactory;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionObjectFactory;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.QuestionManagerDaoFactory;
import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.SurveyFactory;
import CSCI5308.GroupFormationTool.Survey.SurveyObjectFactory;

public class SurveyDaoImpl implements ISurveyDao {

	Logger logger = LogManager.getLogger(SurveyDaoImpl.class);

	@Override
	public ISurvey getSurveyForCourse(ICourse course) {
		PreparedStatement statement = null;
		Connection connection = null;
		ISurvey survey = SurveyFactory.surveyObject(new SurveyObjectFactory());
		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			String selectQuery = SqlQueryUtil.instance().getQueryByKey("surveyForCourse");
			statement = connection.prepareStatement(selectQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			statement.setInt(1, course.getCourseId());
			ResultSet resultSet = statement.executeQuery();
			List<IQuestion> surveyQuestions = new ArrayList<IQuestion>();
			if (!resultSet.next()){
				survey.setQuestionList(surveyQuestions);
			}else {
				resultSet.beforeFirst();
			}
			if (resultSet.next()) {
				resultSet.beforeFirst();
				while (resultSet.next()) {
					survey.setSurveyId(resultSet.getInt("survey_id"));
					survey.setGroupSize(resultSet.getInt("group_size"));
					survey.setSurveyStatus(resultSet.getString("survey_status"));
					int questionId = resultSet.getInt("question_id");
					IQuestion question = QuestionFactory.questionObject(new QuestionObjectFactory());
					question.setQuestionId(questionId);
					question.setQuestionText(resultSet.getString("question_text"));
					question.setQuestionType(resultSet.getString("question_type"));
					question.setQuestionTitle(resultSet.getString("question_title"));
					question.setQuestionNo(resultSet.getInt("s_id"));
					question.setCriteria(resultSet.getString("criteria"));
					ArrayList<Answer> answerList = QuestionManagerDaoFactory.instance().fetchQuestionDAO()
							.getOptionsForQuestion(questionId);
					question.setAnswerList(answerList);
					surveyQuestions.add(question);
				}
				survey.setQuestionList(surveyQuestions);
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
		return survey;
	}

	@Override
	public List<SurveyResponse> getResponseForCourse(ICourse course) {
		PreparedStatement statement = null;
		Connection connection = null;
		List<SurveyResponse> surveyResponses = new ArrayList<>();
		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			String selectQuery = SqlQueryUtil.instance().getQueryByKey("responseForCourse");
			statement = connection.prepareStatement(selectQuery);
			statement.setInt(1, course.getCourseId());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				SurveyResponse response = new SurveyResponse();
				response.setUserId(resultSet.getInt("user_id"));
				response.setQuestionId(resultSet.getInt("question_id"));
				response.setAnswer(resultSet.getString("response_value"));
				surveyResponses.add(response);
			}
		} catch (SQLException e) {
			logger.error("Exception occured while fetching survey responses", e);
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
		return surveyResponses;
	}

	@Override
	public String getSurveyStatusForCourse(ICourse course) {
		PreparedStatement statement = null;
		Connection connection = null;
		String surveyStatus = "";
		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			String selectQuery = SqlQueryUtil.instance().getQueryByKey("surveyStatusForCourse");
			System.out.println("Stage-1");
			statement = connection.prepareStatement(selectQuery);
			System.out.println("Stage-2");
			statement.setInt(1, course.getCourseId());
			System.out.println("Stage-3");
			ResultSet resultSet = statement.executeQuery();
			System.out.println("Stage-4");
			if (resultSet.next()) {
				surveyStatus = resultSet.getString("survey_status");
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
		return surveyStatus;
	}

}

package CSCI5308.GroupFormationTool.Survey.DAO;

import java.sql.*;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import CSCI5308.GroupFormationTool.DBUtil.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.Profile.IUser;
import CSCI5308.GroupFormationTool.Profile.DAO.IUserDao;
import CSCI5308.GroupFormationTool.Profile.DAO.ProfileDaoFactory;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionFactory;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionObjectFactory;

public class GetQuestionsDAOImpl implements IGetQuestionsDAO {
	Logger logger = LogManager.getLogger(GetQuestionsDAOImpl.class);

	public ArrayList<IQuestion> getQuestionByInstructorId() {
		Connection connection = null;
		Statement statement = null;
		ArrayList<IQuestion> questions = new ArrayList<>();
		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			statement = connection.createStatement();
			String query = "SELECT * FROM question WHERE user_id=" + getUserId();
			ResultSet rs = statement.executeQuery(query);
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
		Statement statement = null;
		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			statement = connection.createStatement();
			String query = "SELECT * FROM question WHERE question_id=" + questionId;
			ResultSet rs = statement.executeQuery(query);
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

	public int getUserId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		IUserDao userDao = ProfileDaoFactory.instance().userDao();

		ArrayList<IUser> list = userDao.getByEmail(authentication.getName());

		return list.get(0).getUserId();
	}

	public String getSurveyStatus(int couser_id){
		Connection connection = null;
		Statement statement = null;
		String status="";
		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			statement = connection.createStatement();
			String query = "SELECT survey_status from instructor_survey_association where course_id =" +couser_id;
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				status = rs.getString("course_id");
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
		return status;

	}
}

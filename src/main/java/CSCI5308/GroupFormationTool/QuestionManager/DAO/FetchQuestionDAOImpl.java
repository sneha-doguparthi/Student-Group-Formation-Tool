package CSCI5308.GroupFormationTool.QuestionManager.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import CSCI5308.GroupFormationTool.DBUtil.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.DBUtil.SqlQueryUtil;
import CSCI5308.GroupFormationTool.Model.Answer;
import CSCI5308.GroupFormationTool.Profile.IUser;
import CSCI5308.GroupFormationTool.Profile.DAO.IUserDao;
import CSCI5308.GroupFormationTool.Profile.DAO.ProfileDaoFactory;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionFactory;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionObjectFactory;

public class FetchQuestionDAOImpl implements IFetchQuestionDAO {

	Logger logger = LogManager.getLogger(FetchQuestionDAOImpl.class);

	@Override
	public ArrayList<IQuestion> getQuestionByUserId() {
		Connection connection = null;
		Statement statement = null;
		ArrayList<IQuestion> questions = new ArrayList<>();
		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			statement = connection.createStatement();
			String query = SqlQueryUtil.instance().getQueryByKey("questionList") + getUserId();
			ResultSet rs = statement.executeQuery(query);
			int i = 1;
			while (rs.next()) {
				IQuestion question = QuestionFactory.questionObject(new QuestionObjectFactory());
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
		IUserDao userDao = ProfileDaoFactory.instance().userDao();
		ArrayList<IUser> list = userDao.getByEmail(authentication.getName());
		return list.get(0).getUserId();
	}

	@Override
	public ArrayList<Answer> getOptionsForQuestion(int questionId) {
		Connection connection = null;
		PreparedStatement statement = null;
		ArrayList<Answer> options = new ArrayList<>();
		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			String query = SqlQueryUtil.instance().getQueryByKey("optionsByQId");
			statement = connection.prepareStatement(query);
			statement.setInt(1, questionId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Answer option = new Answer();
				option.setAnswerText(rs.getString("option_text"));
				option.setStoredAs(rs.getString("option_value"));
				options.add(option);
			}
		} catch (SQLException e) {
			logger.error("Exception occurred while getting options for a question: ", e);
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
		return options;
	}

}

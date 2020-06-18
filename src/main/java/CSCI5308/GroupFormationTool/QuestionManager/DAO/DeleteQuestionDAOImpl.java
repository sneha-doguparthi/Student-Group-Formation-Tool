package CSCI5308.GroupFormationTool.QuestionManager.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import CSCI5308.GroupFormationTool.DBConnection.CreateDatabaseConnection;

public class DeleteQuestionDAOImpl implements DeleteQuestionDAO {

	@Override
	public boolean deleteQuestionByQuestionId(Integer questionId) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			statement = connection.createStatement();
			
			deleteQuestionOption(questionId);
			
			String query = "DELETE FROM question WHERE question_id=" + questionId;
			statement.execute(query);
			
		} catch (SQLException e) {
			System.out.println("Exception occured while getting all the questions: \n" + e);
		} finally {
			try {
				if (null != statement) {
					statement.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("Exception occured while closing connection/statement: \n" + e);
			}
		}
	
		return true;
	}

	@Override
	public boolean deleteQuestionOption(int questionId) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			statement = connection.createStatement();
			
			String query = "DELETE FROM multiple_choice_ques_option WHERE question_id=" + questionId;
			statement.execute(query);
			
		} catch (SQLException e) {
			System.out.println("Exception occured while getting all the questions: \n" + e);
		} finally {
			try {
				if (null != statement) {
					statement.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("Exception occured while closing connection/statement: \n" + e);
			}
		}

		return true;
	}

}

package CSCI5308.GroupFormationTool.QuestionManager.DAO;

import CSCI5308.GroupFormationTool.DBConnection.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.Model.Question;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class QuestionManagerDaoImpl implements QuestionManagerDao {
    @Override
    public boolean insertQuestion(Question question) {
        boolean checkType = question.getType().equals("Numeric") || question.getType().equals("Free text");
        question.setDate(Date.valueOf(LocalDate.now()));
        if(checkType){
            Connection connection = null;
            boolean isRegistered = false;
            PreparedStatement statement = null;
            String query = "INSERT INTO question(question_title,question_text,question_type,created_date,user_id) VALUES(?,?,?,?,?);";
            try {
                connection = CreateDatabaseConnection.instance().createConnection();
                statement = connection.prepareStatement(query);
                statement.setString(1, question.getTitle());
                statement.setString(2, question.getQuestion());
                statement.setString(3, question.getType());
                statement.setDate(4,question.getDate());
                statement.setInt(5,1);
                int result = statement.executeUpdate();

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (Exception e) {

                }
            }
            return true;
        }
        else
            return false;
    }
}

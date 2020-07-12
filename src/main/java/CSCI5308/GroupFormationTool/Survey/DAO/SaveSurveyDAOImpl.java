package CSCI5308.GroupFormationTool.Survey.DAO;

import CSCI5308.GroupFormationTool.DBUtil.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.DBUtil.SqlQueryUtil;
import CSCI5308.GroupFormationTool.Survey.SurveyQuestion;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SaveSurveyDAOImpl implements ISaveSurveyDAO {
    private Logger logger = LogManager.getLogger(SaveSurveyDAOImpl.class);

    public boolean saveSurveyQuestions(List<SurveyQuestion> questions) {
        Connection connection = null;
        PreparedStatement statement = null;
        int listSize = questions.size();

        try {
            connection = CreateDatabaseConnection.instance().createConnection();
            for (int i = 0; i < listSize; i++) {
                String query = "INSERT INTO survey_question_association(course_id,question_id,criteria) values(?,?,?)";
                statement = connection.prepareStatement(query);
                statement.setInt(1, questions.get(i).getQuestionId());
                statement.setInt(2, questions.get(i).getQuestionId());
                statement.setString(3, questions.get(i).getCriteria());
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

        return true;
    }

}


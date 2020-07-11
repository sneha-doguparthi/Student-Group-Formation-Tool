package CSCI5308.GroupFormationTool.Survey.DAO;

import CSCI5308.GroupFormationTool.Model.Question;

import java.util.ArrayList;

public interface GetQuestionsDAO {
    ArrayList<Question> getQuestionByInstructorId();
    Question getQuestionById(int questionId);
    int getUserId();

}

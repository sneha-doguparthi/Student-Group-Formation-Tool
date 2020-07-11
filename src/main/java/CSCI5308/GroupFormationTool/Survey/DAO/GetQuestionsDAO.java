package CSCI5308.GroupFormationTool.Survey.DAO;

import CSCI5308.GroupFormationTool.Model.Question;
import CSCI5308.GroupFormationTool.Model.SurveyQuestion;

import java.util.ArrayList;

public interface GetQuestionsDAO {
    ArrayList<SurveyQuestion> getQuestionByInstructorId();
    SurveyQuestion getQuestionById(int questionId);
    int getUserId();

}

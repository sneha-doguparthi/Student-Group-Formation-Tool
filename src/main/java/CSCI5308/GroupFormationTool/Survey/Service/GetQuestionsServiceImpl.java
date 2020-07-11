package CSCI5308.GroupFormationTool.Survey.Service;

import CSCI5308.GroupFormationTool.Model.Question;
import CSCI5308.GroupFormationTool.Model.Survey;
import CSCI5308.GroupFormationTool.Survey.DAO.GetQuestionsDAO;
import CSCI5308.GroupFormationTool.SystemConfig;

import java.util.ArrayList;

public class GetQuestionsServiceImpl implements GetQuestionsService {
    public ArrayList<Question> getQuestionForInstructor() {
        GetQuestionsDAO getQuestion = SystemConfig.instance().getQuestionDAO();
        return getQuestion.getQuestionByInstructorId();
    }
    public Question getOneQuestion(int questionId){
        GetQuestionsDAO getQuestion = SystemConfig.instance().getQuestionDAO();
        return getQuestion.getQuestionById(questionId);
    }
}

package CSCI5308.GroupFormationTool.Survey.Service;

import CSCI5308.GroupFormationTool.Model.Question;
import CSCI5308.GroupFormationTool.Model.Survey;
import CSCI5308.GroupFormationTool.Model.SurveyQuestion;
import CSCI5308.GroupFormationTool.Survey.DAO.GetQuestionsDAO;
import CSCI5308.GroupFormationTool.SystemConfig;

import java.util.ArrayList;
import java.util.List;

public class GetQuestionsServiceImpl implements GetQuestionsService {
    private static Survey survey= new Survey();
    public ArrayList<SurveyQuestion> getQuestionForInstructor() {
        GetQuestionsDAO getQuestion = SystemConfig.instance().getQuestionDAO();
        return getQuestion.getQuestionByInstructorId();
    }
    public Survey getOneQuestion(int questionId){
        GetQuestionsDAO getQuestion = SystemConfig.instance().getQuestionDAO();
        List<SurveyQuestion > surveyQuestionList = survey.getQuestionList();
        surveyQuestionList.add(getQuestion.getQuestionById(questionId));
        survey.setQuestionList(surveyQuestionList);
        return survey;
    }
}

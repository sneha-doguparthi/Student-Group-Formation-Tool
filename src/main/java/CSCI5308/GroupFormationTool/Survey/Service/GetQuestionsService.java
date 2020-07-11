package CSCI5308.GroupFormationTool.Survey.Service;

import CSCI5308.GroupFormationTool.Model.Question;
import CSCI5308.GroupFormationTool.Model.Survey;
import CSCI5308.GroupFormationTool.Model.SurveyQuestion;

import java.util.ArrayList;

public interface GetQuestionsService {
    ArrayList<SurveyQuestion> getQuestionForInstructor();
    Survey getOneQuestion(int questionId);
}

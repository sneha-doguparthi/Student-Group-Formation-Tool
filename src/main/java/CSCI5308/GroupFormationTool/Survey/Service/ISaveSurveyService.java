package CSCI5308.GroupFormationTool.Survey.Service;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.Survey.ISurvey;

import java.util.List;

public interface ISaveSurveyService {
    boolean saveSurveyQuestions(List<IQuestion> questionList, int courseId);
    void saveSurveyDetails(ISurvey survey);
    List<IQuestion> splitQuestionDetails(String questionDetails);
    boolean updateSurveyStatus(int courseId);
}

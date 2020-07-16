package CSCI5308.GroupFormationTool.Course.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.SurveyResponse;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.Survey.ISurvey;

public interface ICourseSurveyService {
	public boolean validateResponses(IQuestion surveyQuestions, ISurvey survey);

	public ArrayList<SurveyResponse> splitSurveyResponse(IQuestion question);

	public String storeSurveyResponse(ArrayList<SurveyResponse> surveyResponse);

	public boolean checkIfSurveySubmitted(int courseId, int userId);
}

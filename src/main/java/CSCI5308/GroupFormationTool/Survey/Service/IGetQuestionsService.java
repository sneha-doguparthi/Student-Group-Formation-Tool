package CSCI5308.GroupFormationTool.Survey.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.SurveyQuestion;

public interface IGetQuestionsService {
	public ArrayList<SurveyQuestion> getQuestionForInstructor();

	public ISurvey getOneQuestion(int questionId);

	public ISurvey deleteQuestion(int questionId);
}

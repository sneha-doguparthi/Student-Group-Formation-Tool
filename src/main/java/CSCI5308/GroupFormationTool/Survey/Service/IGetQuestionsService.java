package CSCI5308.GroupFormationTool.Survey.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.Survey.ISurvey;

public interface IGetQuestionsService {

	public ArrayList<IQuestion> getQuestionForInstructor();

	public ISurvey getOneQuestion(ISurvey survey, int questionId);

	public ISurvey deleteQuestion(ISurvey survey, int questionId);

}

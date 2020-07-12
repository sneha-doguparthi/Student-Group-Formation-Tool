package CSCI5308.GroupFormationTool.Survey.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.Survey.ISurvey;

public interface IGetQuestionsService {
	public ArrayList<IQuestion> getQuestionForInstructor();

	public ISurvey getOneQuestion(int questionId);
}

package CSCI5308.GroupFormationTool.Survey.Service;

import java.util.List;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.Survey.ISurvey;

public interface ISaveSurveyService {

	boolean saveSurveyQuestions(List<IQuestion> questionList, int courseId);

	void saveSurveyDetails(ISurvey survey);

	List<IQuestion> splitQuestionDetails(String questionDetails);

	boolean updateSurveyStatus(int courseId);
	
	void deleteSurveyQuestion(int questionId, int courseId);

}

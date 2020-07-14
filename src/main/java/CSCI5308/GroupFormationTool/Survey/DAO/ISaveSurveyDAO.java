package CSCI5308.GroupFormationTool.Survey.DAO;

import java.util.List;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.Survey;

public interface ISaveSurveyDAO {
	boolean saveSurveyQuestions(List<IQuestion> questions);
	void saveSurveyDetails(ISurvey survey);
	boolean publishSurvey(int course_id);
}

package CSCI5308.GroupFormationTool.Survey.DAO;

import java.util.List;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;

public interface ISaveSurveyDAO {
	boolean saveSurveyQuestions(List<IQuestion> questions);
}

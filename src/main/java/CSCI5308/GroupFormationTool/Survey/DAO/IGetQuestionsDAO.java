package CSCI5308.GroupFormationTool.Survey.DAO;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Survey.SurveyQuestion;

public interface IGetQuestionsDAO {
	public ArrayList<SurveyQuestion> getQuestionByInstructorId();

	public SurveyQuestion getQuestionById(int questionId);

	public int getUserId();

}

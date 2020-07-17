package CSCI5308.GroupFormationTool.Survey.DAO;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;

public interface IGetQuestionsDAO {

	public ArrayList<IQuestion> getQuestionByInstructorId();

	public IQuestion getQuestionById(int questionId);

	public int getUserId();

}

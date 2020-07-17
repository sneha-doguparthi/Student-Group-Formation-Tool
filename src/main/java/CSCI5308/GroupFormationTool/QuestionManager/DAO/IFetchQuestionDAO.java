package CSCI5308.GroupFormationTool.QuestionManager.DAO;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.Answer;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;

public interface IFetchQuestionDAO {

	public ArrayList<IQuestion> getQuestionByUserId();

	public int getUserId();

	public ArrayList<Answer> getOptionsForQuestion(int questionId);

}

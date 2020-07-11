package CSCI5308.GroupFormationTool.QuestionManager.DAO;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;

public interface IFetchQuestionDAO {

	public ArrayList<IQuestion> getQuestionByUserId();

	public int getUserId();

}

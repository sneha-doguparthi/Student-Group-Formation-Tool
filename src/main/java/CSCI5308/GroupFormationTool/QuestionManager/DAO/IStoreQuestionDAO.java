package CSCI5308.GroupFormationTool.QuestionManager.DAO;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;

public interface IStoreQuestionDAO {

	public int saveQuestionDetails(IQuestion question);

}
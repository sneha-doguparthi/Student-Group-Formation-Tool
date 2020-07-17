package CSCI5308.GroupFormationTool.QuestionManager.DAO;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.Answer;

public interface IStoreMcqOptionsDAO {

	public String saveMcqOptionsForQuestion(int questionId, ArrayList<Answer> answerList);

}

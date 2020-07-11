package CSCI5308.GroupFormationTool.QuestionManager.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.Answer;

public interface IStoreMcqOptionService {

	public String saveMcqOptionsForQuestion(int questionId, ArrayList<Answer> answerList);

}

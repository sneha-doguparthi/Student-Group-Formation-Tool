package CSCI5308.GroupFormationTool.QuestionManager.DAO;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.Question;

public interface FetchQuestionDAO {
	public ArrayList<Question> getQuestionByUserId();
	public int getUserId(); 
}

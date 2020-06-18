package CSCI5308.GroupFormationTool.QuestionManager.DAO;

public interface DeleteQuestionDAO {
	public boolean deleteQuestionByQuestionId(Integer questionId);
	public boolean deleteQuestionOption(int questionId);
}

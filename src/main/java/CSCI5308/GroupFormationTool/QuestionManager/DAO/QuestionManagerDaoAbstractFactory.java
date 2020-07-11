package CSCI5308.GroupFormationTool.QuestionManager.DAO;

public abstract class QuestionManagerDaoAbstractFactory {
	public abstract IStoreMcqOptionsDAO storeMcqOptionsDAO();

	public abstract IStoreQuestionDAO storeQuestionDAO();

	public abstract IFetchQuestionDAO fetchQuestionDAO();

	public abstract IDeleteQuestionDAO deleteQuestionDAO();
}

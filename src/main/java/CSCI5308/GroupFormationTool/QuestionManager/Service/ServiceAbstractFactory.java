package CSCI5308.GroupFormationTool.QuestionManager.Service;

public abstract class ServiceAbstractFactory {
	public abstract IDeleteQuestionService deleteQuestionService();

	public abstract IFetchQuestionService fetchQuestionService();

	public abstract ISplitMcqAnswerService splitMcqAnswerService();

	public abstract IStoreMcqOptionService storeMcqOptionService();

	public abstract IStoreQuestionService storeQuestionService();
}

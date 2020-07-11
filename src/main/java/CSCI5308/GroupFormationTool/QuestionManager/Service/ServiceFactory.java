package CSCI5308.GroupFormationTool.QuestionManager.Service;

public class ServiceFactory extends ServiceAbstractFactory {

	private static ServiceFactory questionManagerFactory = null;
	private IDeleteQuestionService deleteQuestionService;
	private IFetchQuestionService fetchQuestionService;
	private ISplitMcqAnswerService splitMcqAnswerService;
	private IStoreMcqOptionService storeMcqOptionService;
	private IStoreQuestionService storeQuestionService;

	private ServiceFactory() {

	}

	public static ServiceFactory instance() {
		if (null == questionManagerFactory) {
			questionManagerFactory = new ServiceFactory();
		}
		return questionManagerFactory;
	}

	@Override
	public IDeleteQuestionService deleteQuestionService() {
		if (null == deleteQuestionService) {
			deleteQuestionService = new DeleteQuestionServiceImpl();
		}
		return deleteQuestionService;
	}

	@Override
	public IFetchQuestionService fetchQuestionService() {
		if (null == fetchQuestionService) {
			fetchQuestionService = new FetchQuestionServiceImpl();
		}
		return fetchQuestionService;
	}

	@Override
	public ISplitMcqAnswerService splitMcqAnswerService() {
		if (null == splitMcqAnswerService) {
			splitMcqAnswerService = new SplitMcqAnswerServiceImpl();
		}
		return splitMcqAnswerService;
	}

	@Override
	public IStoreMcqOptionService storeMcqOptionService() {
		if (null == storeMcqOptionService) {
			storeMcqOptionService = new StoreMcqOptionServiceImpl();
		}
		return storeMcqOptionService;
	}

	@Override
	public IStoreQuestionService storeQuestionService() {
		if (null == storeQuestionService) {
			storeQuestionService = new StoreQuestionServiceImpl();
		}
		return storeQuestionService;
	}

}

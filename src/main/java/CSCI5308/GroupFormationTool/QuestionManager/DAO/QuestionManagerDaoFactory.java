package CSCI5308.GroupFormationTool.QuestionManager.DAO;

public class QuestionManagerDaoFactory extends QuestionManagerDaoAbstractFactory {
	private static QuestionManagerDaoFactory questionDaoFactory = null;
	private IStoreMcqOptionsDAO storeMcqOptionsDao;
	private IStoreQuestionDAO storeQuestionDao;
	private IFetchQuestionDAO fetchQuestionDao;
	private IDeleteQuestionDAO deleteQuestionDao;

	private QuestionManagerDaoFactory() {

	}

	public static QuestionManagerDaoFactory instance() {
		if (null == questionDaoFactory) {
			questionDaoFactory = new QuestionManagerDaoFactory();
		}
		return questionDaoFactory;
	}

	@Override
	public IStoreMcqOptionsDAO storeMcqOptionsDAO() {
		if (null == storeMcqOptionsDao) {
			storeMcqOptionsDao = new StoreMcqOptionsDAOImpl();
		}
		return storeMcqOptionsDao;
	}

	@Override
	public IStoreQuestionDAO storeQuestionDAO() {
		if (null == storeQuestionDao) {
			storeQuestionDao = new StoreQuestionDAOImpl();
		}
		return storeQuestionDao;
	}

	@Override
	public IFetchQuestionDAO fetchQuestionDAO() {
		if (null == fetchQuestionDao) {
			fetchQuestionDao = new FetchQuestionDAOImpl();
		}
		return fetchQuestionDao;
	}

	@Override
	public IDeleteQuestionDAO deleteQuestionDAO() {
		if (null == deleteQuestionDao) {
			deleteQuestionDao = new DeleteQuestionDAOImpl();
		}
		return deleteQuestionDao;
	}

}

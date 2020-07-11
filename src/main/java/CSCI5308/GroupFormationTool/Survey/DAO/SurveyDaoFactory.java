package CSCI5308.GroupFormationTool.Survey.DAO;

public class SurveyDaoFactory extends SurveyDaoAbstractFactory {

	private static SurveyDaoFactory instance = null;
	private IGetQuestionsDAO getQuestionsDAO;

	private SurveyDaoFactory() {
	}

	public static SurveyDaoFactory instance() {
		if (null == instance) {
			instance = new SurveyDaoFactory();
		}
		return instance;
	}

	@Override
	public IGetQuestionsDAO getQuestionsDAO() {
		if (null == getQuestionsDAO) {
			getQuestionsDAO = new GetQuestionsDAOImpl();
		}
		return getQuestionsDAO;
	}

}

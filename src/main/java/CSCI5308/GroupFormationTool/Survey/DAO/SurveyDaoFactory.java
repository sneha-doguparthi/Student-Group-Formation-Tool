package CSCI5308.GroupFormationTool.Survey.DAO;

public class SurveyDaoFactory extends SurveyDaoAbstractFactory {

	private static SurveyDaoFactory instance = null;
	private IGetQuestionsDAO getQuestionsDAO;
	private ISurveyDao surveyDao;

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

	@Override
	public ISurveyDao surveyDao() {
		if (null == surveyDao) {
			surveyDao = new SurveyDaoImpl();
		}
		return surveyDao;
	}

}

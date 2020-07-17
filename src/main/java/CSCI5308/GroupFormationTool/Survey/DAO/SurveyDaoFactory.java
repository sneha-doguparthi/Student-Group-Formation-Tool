package CSCI5308.GroupFormationTool.Survey.DAO;

public class SurveyDaoFactory extends SurveyDaoAbstractFactory {

	private static SurveyDaoFactory instance = null;
	private IGetQuestionsDAO getQuestionsDAO;
	private ISurveyDao surveyDao;
	private ISaveSurveyDAO saveSurveyDAO;

	private SurveyDaoFactory() {
	}

	public static SurveyDaoFactory instance() {
		if (null == instance) {
			instance = new SurveyDaoFactory();
		}
		return instance;
	}

	public IGetQuestionsDAO getQuestionsDAO() {
		if (null == getQuestionsDAO) {
			getQuestionsDAO = new GetQuestionsDAOImpl();
		}
		return getQuestionsDAO;
	}

	 public ISurveyDao surveyDao() {
	 	if (null == surveyDao) {
	 		surveyDao = new SurveyDaoImpl();
	 	}
	 	return surveyDao;
	 }

	 public ISaveSurveyDAO saveSurveyDAO() {
	 	if (null == saveSurveyDAO) {
	 		saveSurveyDAO = new SaveSurveyDAOImpl();
	 	}
	 	return saveSurveyDAO;
	 }

}

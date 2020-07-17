package CSCI5308.GroupFormationTool.Survey.Service;

public class SurveyServiceFactory extends SurveyServiceAbstractFactory {

	private static SurveyServiceFactory instance = null;
	private IGetQuestionsService getQuestionsService;
	private ISurveyService surveyService;
	private ISaveSurveyService saveSurveyService;
	private IDesignGroupService designGroupService;

	private SurveyServiceFactory() {
	}

	public static SurveyServiceFactory instance() {
		if (null == instance) {
			instance = new SurveyServiceFactory();
		}
		return instance;
	}

	public IGetQuestionsService getQuestionsService() {
		if (null == getQuestionsService) {
			getQuestionsService = new GetQuestionsServiceImpl();
		}
		return getQuestionsService;
	}

	 public ISurveyService surveyService() {
	 	if (null == surveyService) {
	 		surveyService = new SurveyServiceImpl();
	 	}
	 	return surveyService;
	 }

	public ISaveSurveyService saveSurveyService() {
		if (null == saveSurveyService) {
			saveSurveyService = new SaveSurveyServiceImpl();
		}
		return saveSurveyService;
	}

	public IDesignGroupService designGroupService() {
		if (null == designGroupService) {
			designGroupService = new DesignGroupServiceImpl();
		}
		return designGroupService;
	}
}

package CSCI5308.GroupFormationTool.Survey.Service;

public class SurveyServiceFactory extends SurveyServiceAbstractFactory {

	private static SurveyServiceFactory instance = null;
	private IGetQuestionsService getQuestionsService;

	private SurveyServiceFactory() {
	}

	public static SurveyServiceFactory instance() {
		if (null == instance) {
			instance = new SurveyServiceFactory();
		}
		return instance;
	}

	@Override
	public IGetQuestionsService getQuestionsService() {
		if (null == getQuestionsService) {
			getQuestionsService = new GetQuestionsServiceImpl();
		}
		return getQuestionsService;
	}

}

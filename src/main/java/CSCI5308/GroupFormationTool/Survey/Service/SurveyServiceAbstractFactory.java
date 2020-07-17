package CSCI5308.GroupFormationTool.Survey.Service;

public abstract class SurveyServiceAbstractFactory {

	public abstract IGetQuestionsService getQuestionsService();

	public abstract ISaveSurveyService saveSurveyService();

	public abstract IDesignGroupService designGroupService();

}

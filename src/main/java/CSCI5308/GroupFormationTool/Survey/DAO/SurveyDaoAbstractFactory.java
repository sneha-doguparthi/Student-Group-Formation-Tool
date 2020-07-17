package CSCI5308.GroupFormationTool.Survey.DAO;

public abstract class SurveyDaoAbstractFactory {

	public abstract IGetQuestionsDAO getQuestionsDAO();

	public abstract ISaveSurveyDAO saveSurveyDAO();

}

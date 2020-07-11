package CSCI5308.GroupFormationTool.Survey;

public class SurveyFactory {

	public static ISurvey surveyObject(SurveyAbstractFactory surveyAbstractFactory) {
		return surveyAbstractFactory.surveyObject();
	}

}

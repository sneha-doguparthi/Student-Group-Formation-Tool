package CSCI5308.GroupFormationTool.Survey;

public class SurveyObjectFactory extends SurveyAbstractFactory {

	@Override
	public ISurvey surveyObject() {
		return new Survey();
	}
}

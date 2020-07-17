package CSCI5308.GroupFormationTool.Course.DAO;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.SurveyResponse;

public interface ICourseSurveyDao {
	public String storeSurveyResponse(ArrayList<SurveyResponse> surveyResponse);

	public boolean checkIfSurveySubmitted(int courseId, int userId);
}

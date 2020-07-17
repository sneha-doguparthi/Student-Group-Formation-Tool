package CSCI5308.GroupFormationTool.Survey.Service;

import java.util.List;

import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.Model.SurveyResponse;
import CSCI5308.GroupFormationTool.Survey.ISurvey;

public interface ISurveyService {

	public ISurvey getSurveyForCourse(ICourse course);

	public List<SurveyResponse> getResponseForCourse(ICourse course);

	String getSurveyStatusForCourse(ICourse course);

}

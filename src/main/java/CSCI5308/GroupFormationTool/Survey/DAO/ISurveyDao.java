package CSCI5308.GroupFormationTool.Survey.DAO;

import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.Model.SurveyResponse;
import CSCI5308.GroupFormationTool.Survey.ISurvey;

import java.util.List;

public interface ISurveyDao {
	public ISurvey getSurveyForCourse(ICourse course);
	public List<SurveyResponse> getResponseForCourse(ICourse course);
}

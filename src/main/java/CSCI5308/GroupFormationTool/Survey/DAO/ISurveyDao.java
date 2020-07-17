package CSCI5308.GroupFormationTool.Survey.DAO;

import java.util.List;

import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.Model.SurveyResponse;
import CSCI5308.GroupFormationTool.Survey.ISurvey;

public interface ISurveyDao {

	public ISurvey getSurveyForCourse(ICourse course);

	public List<SurveyResponse> getResponseForCourse(ICourse course);

	public String getSurveyStatusForCourse(ICourse course);
}

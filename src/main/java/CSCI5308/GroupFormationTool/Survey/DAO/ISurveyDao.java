package CSCI5308.GroupFormationTool.Survey.DAO;

import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.Survey.ISurvey;

public interface ISurveyDao {
	public ISurvey getSurveyForCourse(ICourse course);
}

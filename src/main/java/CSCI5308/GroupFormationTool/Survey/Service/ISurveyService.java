package CSCI5308.GroupFormationTool.Survey.Service;

import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.Survey.ISurvey;

public interface ISurveyService {
	public ISurvey getSurveyForCourse(ICourse course);
}

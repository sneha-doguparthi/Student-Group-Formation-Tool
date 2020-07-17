package CSCI5308.GroupFormationTool.Survey.Service;

import java.util.List;

import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.Model.SurveyResponse;
import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.DAO.ISurveyDao;
import CSCI5308.GroupFormationTool.Survey.DAO.SurveyDaoFactory;

public class SurveyServiceImpl implements ISurveyService {

	@Override
	public ISurvey getSurveyForCourse(ICourse course) {
		ISurveyDao surveyDao = SurveyDaoFactory.instance().surveyDao();
		return surveyDao.getSurveyForCourse(course);
	}

	@Override
	public List<SurveyResponse> getResponseForCourse(ICourse course) {
		ISurveyDao surveyDao = SurveyDaoFactory.instance().surveyDao();
		return surveyDao.getResponseForCourse(course);
	}

	@Override
	public String getSurveyStatusForCourse(ICourse course) {
		ISurveyDao surveyDao = SurveyDaoFactory.instance().surveyDao();
		return surveyDao.getSurveyStatusForCourse(course);
	}
	
}

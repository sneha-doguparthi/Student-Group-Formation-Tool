package CSCI5308.GroupFormationTool.Survey.Service;

import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.Survey.DAO.ISaveSurveyDAO;
import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.DAO.ISurveyDao;
import CSCI5308.GroupFormationTool.Survey.DAO.SurveyDaoFactory;

public class SurveyServiceImpl implements ISurveyService {

	@Override
	public ISurvey getSurveyForCourse(ICourse course) {
		ISurveyDao surveyDao = SurveyDaoFactory.instance().surveyDao();
		return surveyDao.getSurveyForCourse(course);
	}


}

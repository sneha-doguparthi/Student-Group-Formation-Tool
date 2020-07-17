package CSCI5308.GroupFormationTool.Course.Service;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.Course.DAO.CourseDaoFactory;
import CSCI5308.GroupFormationTool.Course.DAO.ICourseSurveyDao;
import CSCI5308.GroupFormationTool.Model.SurveyResponse;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.Survey.ISurvey;

public class CourseSurveyServiceImpl implements ICourseSurveyService {

	private Logger logger = LogManager.getLogger(CourseSurveyServiceImpl.class);

	@Override
	public boolean validateResponses(IQuestion surveyQuestions, ISurvey survey) {
		String[] questionAndAnwers = surveyQuestions.getQuestionType().split(",");
		int qAnsweredCount = 0;
		for (String qNa : questionAndAnwers) {
			if (null != qNa && qNa.contains(" - ")) {
				qAnsweredCount++;
			}
		}
		if (null != survey.getQuestionList() && qAnsweredCount >= survey.getQuestionList().size()) {
			logger.info("Survey question responses validated successfilly.");
			return true;
		}
		logger.info("Survey question responses validation failed. All answers are not answered.");
		return false;
	}

	@Override
	public ArrayList<SurveyResponse> splitSurveyResponse(IQuestion question) {
		String[] questionAndAnwers = question.getQuestionType().split(",");
		ArrayList<SurveyResponse> splittedResponses = new ArrayList<>();
		for (String qNa : questionAndAnwers) {
			SurveyResponse response = new SurveyResponse();
			if (null != qNa && qNa.contains(" - ")) {
				int questionId = Integer.parseInt(qNa.split(" - ")[0]);
				String answer = qNa.split(" - ")[1];
				response.setQuestionId(questionId);
				response.setAnswer(answer);
				splittedResponses.add(response);
			}
		}
		return splittedResponses;
	}

	@Override
	public String storeSurveyResponse(ArrayList<SurveyResponse> surveyResponse) {
		ICourseSurveyDao courseSurveyDao = CourseDaoFactory.instance().courseSurveyDao();
		return courseSurveyDao.storeSurveyResponse(surveyResponse);
	}

	@Override
	public boolean checkIfSurveySubmitted(int courseId, int userId) {
		ICourseSurveyDao courseSurveyDao = CourseDaoFactory.instance().courseSurveyDao();
		return courseSurveyDao.checkIfSurveySubmitted(courseId, userId);
	}

}

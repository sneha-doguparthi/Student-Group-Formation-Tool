package CSCI5308.GroupFormationTool.Survey.Service;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.DAO.IGetQuestionsDAO;
import CSCI5308.GroupFormationTool.Survey.DAO.SurveyDaoFactory;

public class GetQuestionsServiceImpl implements IGetQuestionsService {

	public ArrayList<IQuestion> getQuestionForInstructor() {
		IGetQuestionsDAO getQuestionDao = SurveyDaoFactory.instance().getQuestionsDAO();
		return getQuestionDao.getQuestionByInstructorId();
	}

	public ISurvey getOneQuestion(ISurvey survey, int questionId) {
		IGetQuestionsDAO getQuestionDao = SurveyDaoFactory.instance().getQuestionsDAO();
		IQuestion questionById = getQuestionDao.getQuestionById(questionId);
		List<IQuestion> surveyQuestionList = survey.getQuestionList();
		if (null == surveyQuestionList) {
			surveyQuestionList = new ArrayList<IQuestion>();
		}
		surveyQuestionList.add(questionById);
		survey.setQuestionList(surveyQuestionList);
		return survey;
	}

	 public ISurvey deleteQuestion(ISurvey survey, int questionId) {
	 	List<IQuestion> surveyQuestionList = survey.getQuestionList();
	 	for (IQuestion question : surveyQuestionList) {
			if (question.getQuestionId() == questionId) {
	 			surveyQuestionList.remove(question);
	 			break;
	 		}
		}
	 	survey.setQuestionList(surveyQuestionList);
		return survey;
	 }

}

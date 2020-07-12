package CSCI5308.GroupFormationTool.Survey.Service;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionFactory;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionObjectFactory;
import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.SurveyFactory;
import CSCI5308.GroupFormationTool.Survey.SurveyObjectFactory;
import CSCI5308.GroupFormationTool.Survey.SurveyQuestion;
import CSCI5308.GroupFormationTool.Survey.DAO.IGetQuestionsDAO;
import CSCI5308.GroupFormationTool.Survey.DAO.SurveyDaoFactory;

public class GetQuestionsServiceImpl implements IGetQuestionsService {

	ISurvey survey = SurveyFactory.surveyObject(new SurveyObjectFactory());
	private static List<SurveyQuestion> surveyQuestionList = new ArrayList<SurveyQuestion>();
	public ArrayList<SurveyQuestion> getQuestionForInstructor() {
		IGetQuestionsDAO getQuestionDao = SurveyDaoFactory.instance().getQuestionsDAO();
		return getQuestionDao.getQuestionByInstructorId();
	}

	public ISurvey getOneQuestion(int questionId) {
		IGetQuestionsDAO getQuestionDao = SurveyDaoFactory.instance().getQuestionsDAO();
		surveyQuestionList.add(getQuestionDao.getQuestionById(questionId));
		survey.setQuestionList(surveyQuestionList);
		return survey;
	}

	public ISurvey deleteQuestion(int questionId) {
		for (SurveyQuestion question:surveyQuestionList){
			if(question.getQuestionId() == questionId){
				surveyQuestionList.remove(question);
			}
		}
		return survey;
	}

}

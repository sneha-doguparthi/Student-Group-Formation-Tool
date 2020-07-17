package CSCI5308.GroupFormationTool.Survey.Service;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionFactory;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionObjectFactory;
import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.DAO.ISaveSurveyDAO;
import CSCI5308.GroupFormationTool.Survey.DAO.SurveyDaoFactory;

public class SaveSurveyServiceImpl implements ISaveSurveyService {

	public List<IQuestion> splitQuestionDetails(String questionDetails) {
		List<IQuestion> questionList = new ArrayList<IQuestion>();
		String[] details = questionDetails.split(",");
		for (int i = 0; i < details.length; i++) {
			IQuestion question = QuestionFactory.questionObject(new QuestionObjectFactory());
			System.out.println(details[i]);
			String[] element = details[i].split(" - ");
			question.setQuestionId(Integer.parseInt(element[0]));
			question.setCriteria(element[1]);
			questionList.add(question);
		}
		return questionList;
	}

	public boolean saveSurveyQuestions(List<IQuestion> surveyQuestions, int courseId) {
		ISaveSurveyDAO saveSurveyDAO = SurveyDaoFactory.instance().saveSurveyDAO();
		for (IQuestion question : surveyQuestions) {
			question.setCourseId(courseId);
		}
		saveSurveyDAO.saveSurveyQuestions(surveyQuestions);
		return false;
	}

	public void saveSurveyDetails(ISurvey survey) {
		ISaveSurveyDAO saveSurveyDAO = SurveyDaoFactory.instance().saveSurveyDAO();
		saveSurveyDAO.saveSurveyDetails(survey);
	}
	
	public void deleteSurveyQuestion(int questionId, int courseId) {
		ISaveSurveyDAO saveSurveyDAO = SurveyDaoFactory.instance().saveSurveyDAO();
		saveSurveyDAO.deleteSurveyQuestion(questionId, courseId);
	}

	public boolean updateSurveyStatus(int courseId) {
		ISaveSurveyDAO saveSurveyDAO = SurveyDaoFactory.instance().saveSurveyDAO();
		return saveSurveyDAO.publishSurvey(courseId);
	}
}

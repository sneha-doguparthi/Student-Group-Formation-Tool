package CSCI5308.GroupFormationTool.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.SurveyFactory;
import CSCI5308.GroupFormationTool.Survey.SurveyObjectFactory;

class SurveyModelTest {

	@Test
	void getSurveyId() {
		ISurvey survey = SurveyFactory.surveyObject(new SurveyObjectFactory());
		survey.setSurveyId(1);
		assertEquals(survey.getSurveyId(), 1);
	}

	@Test
	void setSurveyId() {
		ISurvey survey = SurveyFactory.surveyObject(new SurveyObjectFactory());
		survey.setSurveyId(1);
		assertEquals(survey.getSurveyId(), 1);
	}

	@Test
	void getCourseId() {
		ISurvey survey = SurveyFactory.surveyObject(new SurveyObjectFactory());
		survey.setCourseId(53);
		assertEquals(survey.getCourseId(), 53);
	}

	@Test
	void setCourseId() {
		ISurvey survey = SurveyFactory.surveyObject(new SurveyObjectFactory());
		survey.setCourseId(53);
		assertEquals(survey.getCourseId(), 53);
	}

	@Test
	void getGroupSize() {
		ISurvey survey = SurveyFactory.surveyObject(new SurveyObjectFactory());
		survey.setGroupSize(4);
		assertEquals(survey.getGroupSize(), 4);
	}

	@Test
	void setGroupSize() {
		ISurvey survey = SurveyFactory.surveyObject(new SurveyObjectFactory());
		survey.setGroupSize(4);
		assertEquals(survey.getGroupSize(), 4);
	}

}
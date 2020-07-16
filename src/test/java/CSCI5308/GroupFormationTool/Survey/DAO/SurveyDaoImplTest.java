package CSCI5308.GroupFormationTool.Survey.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Course.CourseFactory;
import CSCI5308.GroupFormationTool.Course.CourseObjectFactory;
import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.SurveyFactory;
import CSCI5308.GroupFormationTool.Survey.SurveyObjectFactory;

class SurveyDaoImplTest {
	ISurveyDao surveyDaoMock = mock(SurveyDaoImpl.class);

	@Test
	void getSurveyForCourse() {
		ICourse course = CourseFactory.courseObject(new CourseObjectFactory());
		course.setCourseCode("5409");
		course.setCourseId(12);
		course.setCourseName("Web Development");

		ISurvey survey = SurveyFactory.surveyObject(new SurveyObjectFactory());
		survey.setCourseId(12);
		survey.setGroupSize(3);

		when(surveyDaoMock.getSurveyForCourse(course)).thenReturn(survey);
		assertEquals(surveyDaoMock.getSurveyForCourse(course), survey, "Error");
		verify(surveyDaoMock).getSurveyForCourse(course);
	}
}
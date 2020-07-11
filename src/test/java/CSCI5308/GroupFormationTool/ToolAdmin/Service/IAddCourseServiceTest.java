package CSCI5308.GroupFormationTool.ToolAdmin.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Course.Course;
import CSCI5308.GroupFormationTool.Utilities.ApplicationConstants;

public class IAddCourseServiceTest {
	IAddCourseService addCourseService = mock(AddCourseServiceImpl.class);
	Course course;

	public IAddCourseServiceTest() {
		course = new Course();
		course.setCourseId(1);
		course.setCourseCode("6708");
		course.setCourseName("Adv. Web Development");
	}

	@Test
	public void testAddCourse() {
		when(addCourseService.addNewCourse(course)).thenReturn(ApplicationConstants.COURSE_ADDED);
		assertEquals(addCourseService.addNewCourse(course), ApplicationConstants.COURSE_ADDED);
		verify(addCourseService).addNewCourse(course);
	}

}
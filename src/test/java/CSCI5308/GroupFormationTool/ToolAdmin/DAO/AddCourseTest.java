package CSCI5308.GroupFormationTool.ToolAdmin.DAO;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Model.Course;
import CSCI5308.GroupFormationTool.Utilities.ApplicationConstants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AddCourseTest {
	AddCourse addCourse = mock(AddCourseImpl.class);
	Course course;

	public AddCourseTest() {
		course = new Course();
		course.setCourseId(1);
		course.setCourseCode("6708");
		course.setCourseName("Adv. Web Development");
	}

	@Test
	public void testAddCourse() {
		when(addCourse.addNewCourse(course)).thenReturn(ApplicationConstants.COURSE_ADDED);
		assertEquals(addCourse.addNewCourse(course), ApplicationConstants.COURSE_ADDED);
		verify(addCourse).addNewCourse(course);
	}

	@Test
	public void testCheckIfCourseExists() {
		when(addCourse.checkIfCourseExists(course)).thenReturn(true);
		assertEquals(addCourse.checkIfCourseExists(course), true);
		verify(addCourse).checkIfCourseExists(course);
	}
}

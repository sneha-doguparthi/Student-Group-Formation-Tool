package CSCI5308.GroupFormationTool.Profile.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Course.CourseFactory;
import CSCI5308.GroupFormationTool.Course.CourseObjectFactory;
import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.Course.DAO.CourseDaoImpl;
import CSCI5308.GroupFormationTool.Course.DAO.ICourseDao;

public class CourseDaoImplTest {

	ICourseDao courseDaoImplMock = mock(CourseDaoImpl.class);

	@Test
	void testGetAll() {

		ArrayList<ICourse> list = new ArrayList<>();

		ICourse courses = CourseFactory.courseObject(new CourseObjectFactory());

		courses.setCourseId(1);
		courses.setCourseCode("CSCI5100");
		courses.setCourseName("Communication Skills");

		list.add(courses);

		when(courseDaoImplMock.getAll()).thenReturn(list);
		assertEquals(courseDaoImplMock.getAll(), list, "Error getting course data");
		verify(courseDaoImplMock).getAll();
	}

	@Test
	void testGetById() {

		ICourse course = CourseFactory.courseObject(new CourseObjectFactory());
		course.setCourseId(1);
		course.setCourseCode("CSCI5100");
		course.setCourseName("Communication Skills");

		when(courseDaoImplMock.getById(1)).thenReturn(course);
		assertEquals(courseDaoImplMock.getById(1), course, "Objects does not match");
		verify(courseDaoImplMock).getById(1);
	}
}

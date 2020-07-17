package CSCI5308.GroupFormationTool.Model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Course.CourseFactory;
import CSCI5308.GroupFormationTool.Course.CourseObjectFactory;
import CSCI5308.GroupFormationTool.Course.ICourse;

public class CourseModelTest {

	@Test
	void testGetCourseId() {
		ICourse course = CourseFactory.courseObject(new CourseObjectFactory());
		course.setCourseId(5308);
		assertTrue(course.getCourseId().equals(5308));
	}

	@Test
	void testSetCourseId() {
		ICourse course = CourseFactory.courseObject(new CourseObjectFactory());
		course.setCourseId(5308);
		assertTrue(course.getCourseId().equals(5308));
	}

	@Test
	void testGetCourseCode() {
		ICourse course = CourseFactory.courseObject(new CourseObjectFactory());
		course.setCourseCode("CSCI5308");
		assertTrue(course.getCourseCode().equals("CSCI5308"));
	}

	@Test
	void testSetCourseCode() {
		ICourse course = CourseFactory.courseObject(new CourseObjectFactory());
		course.setCourseCode("CSCI5308");
		assertTrue(course.getCourseCode().equals("CSCI5308"));
	}

	@Test
	void testGetCourseName() {
		ICourse course = CourseFactory.courseObject(new CourseObjectFactory());
		course.setCourseName("Advanced Topics in Software Development");
		assertTrue(course.getCourseName().equals("Advanced Topics in Software Development"));
	}

	@Test
	void testSetCourseName() {
		ICourse course = CourseFactory.courseObject(new CourseObjectFactory());
		course.setCourseName("Advanced Topics in Software Development");
		assertTrue(course.getCourseName().equals("Advanced Topics in Software Development"));
	}

}
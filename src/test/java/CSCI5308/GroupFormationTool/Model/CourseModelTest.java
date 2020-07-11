package CSCI5308.GroupFormationTool.Model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Course.Course;

public class CourseModelTest {

	@Test
	void testGetCourseId() {
		Course course = new Course();
		course.setCourseId(5308);
		assertTrue(course.getCourseId().equals(5308));
	}

	@Test
	void testSetCourseId() {
		Course course = new Course();
		course.setCourseId(5308);
		assertTrue(course.getCourseId().equals(5308));
	}

	@Test
	void testGetCourseCode() {
		Course course = new Course();
		course.setCourseCode("CSCI5308");
		assertTrue(course.getCourseCode().equals("CSCI5308"));
	}

	@Test
	void testSetCourseCode() {
		Course course = new Course();
		course.setCourseCode("CSCI5308");
		assertTrue(course.getCourseCode().equals("CSCI5308"));
	}

	@Test
	void testGetCourseName() {
		Course course = new Course();
		course.setCourseName("Advanced Topics in Software Development");
		assertTrue(course.getCourseName().equals("Advanced Topics in Software Development"));
	}

	@Test
	void testSetCourseName() {
		Course course = new Course();
		course.setCourseName("Advanced Topics in Software Development");
		assertTrue(course.getCourseName().equals("Advanced Topics in Software Development"));
	}

}
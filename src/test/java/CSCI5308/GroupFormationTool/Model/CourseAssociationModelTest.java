package CSCI5308.GroupFormationTool.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CourseAssociationModelTest {

	@Test
	void testGetRegistrationId() {
		CourseAssociation courseAssociation = new CourseAssociation();
		courseAssociation.setRegistrationId(1);
		assertEquals(courseAssociation.getRegistrationId(), 1);
	}

	@Test
	void testSetRegistrationId() {
		CourseAssociation courseAssociation = new CourseAssociation();
		courseAssociation.setRegistrationId(1);
		assertEquals(courseAssociation.getRegistrationId(), 1);
	}

	@Test
	void testGetUserId() {
		CourseAssociation courseAssociation = new CourseAssociation();
		courseAssociation.setUserId(1);
		assertEquals(courseAssociation.getUserId(), 1);
	}

	@Test
	void testSetUserId() {
		CourseAssociation courseAssociation = new CourseAssociation();
		courseAssociation.setUserId(1);
		assertEquals(courseAssociation.getUserId(), 1);
	}

	@Test
	void testGetCourseId() {
		CourseAssociation courseAssociation = new CourseAssociation();
		courseAssociation.setCourseId(1);
		assertEquals(courseAssociation.getCourseId(), (1));
	}

	@Test
	void testSetCourseId() {
		CourseAssociation courseAssociation = new CourseAssociation();
		courseAssociation.setCourseId(1);
		assertEquals(courseAssociation.getCourseId(), (1));
	}

	@Test
	void testGetRoleId() {
		CourseAssociation courseAssociation = new CourseAssociation();
		courseAssociation.setRoleId(1);
		assertEquals(courseAssociation.getRoleId(), 1);
	}

	@Test
	void testSetRoleId() {
		CourseAssociation courseAssociation = new CourseAssociation();
		courseAssociation.setRoleId(1);
		assertEquals(courseAssociation.getRoleId(), 1);
	}

}

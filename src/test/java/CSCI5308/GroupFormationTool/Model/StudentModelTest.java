package CSCI5308.GroupFormationTool.Model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StudentModelTest {

	@Test
	void testGetBId() {
		Student student = new Student();
		student.setbId("B00789789");
		assertTrue(student.getbId().equals("B00789789"));
	}

	@Test
	void testSetBId() {
		Student student = new Student();
		student.setbId("B00789789");
		assertTrue(student.getbId().equals("B00789789"));
	}

	@Test
	void testGetFirstName() {
		Student student = new Student();
		student.setFirstName("Nick");
		assertTrue(student.getFirstName().equals("Nick"));
	}

	@Test
	void testSetFirstName() {
		Student student = new Student();
		student.setFirstName("Nick");
		assertTrue(student.getFirstName().equals("Nick"));
	}

	@Test
	void testGetLastName() {
		Student student = new Student();
		student.setLastName("Fury");
		assertTrue(student.getLastName().equals("Fury"));
	}

	@Test
	void testSetLastName() {
		Student student = new Student();
		student.setLastName("Fury");
		assertTrue(student.getLastName().equals("Fury"));
	}

	@Test
	void testGetEmail() {
		Student student = new Student();
		student.setEmail("nf@marveldal.ca");
		assertTrue(student.getEmail().equals("nf@marveldal.ca"));
	}

	@Test
	void testSetEmail() {
		Student student = new Student();
		student.setEmail("nf@marveldal.ca");
		assertTrue(student.getEmail().equals("nf@marveldal.ca"));
	}

}

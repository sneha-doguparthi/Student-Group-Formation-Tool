package CSCI5308.GroupFormationTool.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UserModelTest {

	@Test
	void testGetUserId() {
		User user = new User();
		user.setUserId(1);
		assertEquals(user.getUserId(), 1);
	}

	@Test
	void testSetUserId() {
		User user = new User();
		user.setUserId(1);
		assertEquals(user.getUserId(), 1);
	}

	@Test
	void testGetFirstName() {
		User user = new User();
		user.setFirstName("Nick");
		assertTrue(user.getFirstName().equals("Nick"));
	}

	@Test
	void testSetFirstName() {
		User user = new User();
		user.setFirstName("Nick");
		assertTrue(user.getFirstName().equals("Nick"));
	}

	@Test
	void testGetLastName() {
		User user = new User();
		user.setLastName("Fury");
		assertTrue(user.getLastName().equals("Fury"));
	}

	@Test
	void testSetLastName() {
		User user = new User();
		user.setLastName("Fury");
		assertTrue(user.getLastName().equals("Fury"));
	}

	@Test
	void testGetBannerId() {
		User user = new User();
		user.setBannerId("B00181818");
		assertTrue(user.getBannerId().equals("B00181818"));
	}

	@Test
	void testSetBannerId() {
		User user = new User();
		user.setBannerId("B00181818");
		assertTrue(user.getBannerId().equals("B00181818"));
	}

	@Test
	void testGetEmail() {
		User user = new User();
		user.setEmail("nf@maarveldal.ca");
		assertTrue(user.getEmail().equals("nf@maarveldal.ca"));
	}

	@Test
	void testSetEmail() {
		User user = new User();
		user.setEmail("nf@maarveldal.ca");
		assertTrue(user.getEmail().equals("nf@maarveldal.ca"));
	}

	@Test
	void testGetPassword() {
		User user = new User();
		user.setPassword("iamthespy");
		assertTrue(user.getPassword().equals("iamthespy"));
	}

	@Test
	void testSetPassword() {
		User user = new User();
		user.setPassword("iamthespy");
		assertTrue(user.getPassword().equals("iamthespy"));
	}

	@Test
	void testGetConfirmPassword() {
		User user = new User();
		user.setConfirmPassword("iamthespy");
		assertTrue(user.getConfirmPassword().equals("iamthespy"));
	}

	@Test
	void testSetConfirmPassword() {
		User user = new User();
		user.setConfirmPassword("iamthespy");
		assertTrue(user.getConfirmPassword().equals("iamthespy"));
	}

	@Test
	void testGetUser_type() {
		User user = new User();
		user.setUserType("A");
		assertTrue(user.getUserType().equals("A"));
	}

	@Test
	void testSetUser_type() {
		User user = new User();
		user.setUserType("A");
		assertTrue(user.getUserType().equals("A"));
	}

}

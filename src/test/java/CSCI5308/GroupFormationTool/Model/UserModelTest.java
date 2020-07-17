package CSCI5308.GroupFormationTool.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Profile.IUser;
import CSCI5308.GroupFormationTool.Profile.UserFactory;
import CSCI5308.GroupFormationTool.Profile.UserObjectFactory;

public class UserModelTest {

	@Test
	void testGetUserId() {
		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setUserId(1);
		assertEquals(user.getUserId(), 1);
	}

	@Test
	void testSetUserId() {
		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setUserId(1);
		assertEquals(user.getUserId(), 1);
	}

	@Test
	void testGetFirstName() {
		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setFirstName("Nick");
		assertTrue(user.getFirstName().equals("Nick"));
	}

	@Test
	void testSetFirstName() {
		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setFirstName("Nick");
		assertTrue(user.getFirstName().equals("Nick"));
	}

	@Test
	void testGetLastName() {
		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setLastName("Fury");
		assertTrue(user.getLastName().equals("Fury"));
	}

	@Test
	void testSetLastName() {
		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setLastName("Fury");
		assertTrue(user.getLastName().equals("Fury"));
	}

	@Test
	void testGetBannerId() {
		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setBannerId("B00181818");
		assertTrue(user.getBannerId().equals("B00181818"));
	}

	@Test
	void testSetBannerId() {
		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setBannerId("B00181818");
		assertTrue(user.getBannerId().equals("B00181818"));
	}

	@Test
	void testGetEmail() {
		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setEmail("nf@maarveldal.ca");
		assertTrue(user.getEmail().equals("nf@maarveldal.ca"));
	}

	@Test
	void testSetEmail() {
		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setEmail("nf@maarveldal.ca");
		assertTrue(user.getEmail().equals("nf@maarveldal.ca"));
	}

	@Test
	void testGetPassword() {
		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setPassword("iamthespy");
		assertTrue(user.getPassword().equals("iamthespy"));
	}

	@Test
	void testSetPassword() {
		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setPassword("iamthespy");
		assertTrue(user.getPassword().equals("iamthespy"));
	}

	@Test
	void testGetConfirmPassword() {
		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setConfirmPassword("iamthespy");
		assertTrue(user.getConfirmPassword().equals("iamthespy"));
	}

	@Test
	void testSetConfirmPassword() {
		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setConfirmPassword("iamthespy");
		assertTrue(user.getConfirmPassword().equals("iamthespy"));
	}

	@Test
	void testGetUser_type() {
		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setUserType("A");
		assertTrue(user.getUserType().equals("A"));
	}

	@Test
	void testSetUser_type() {
		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setUserType("A");
		assertTrue(user.getUserType().equals("A"));
	}

}

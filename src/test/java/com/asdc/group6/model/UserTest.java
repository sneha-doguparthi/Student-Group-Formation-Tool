package com.asdc.group6.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.asdc.group6.Models.User;

class UserTest {

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
		user.setFirstName("Alex");
		assertTrue(user.getFirstName().equals("Alex"));
	}

	@Test
	void testSetFirstName() {
		User user = new User();
		user.setFirstName("Alex");
		assertTrue(user.getFirstName().equals("Alex"));
	}

	@Test
	void testGetLastName() {
		User u = new User();
		u.setLastName("Gomez");
		assertTrue(u.getLastName().equals("Gomez"));
	}

	@Test
	void testSetLastName() {
		User user = new User();
		user.setLastName("Gomez");
		assertTrue(user.getLastName().equals("Gomez"));
	}

	@Test
	void testGetBannerId() {
		User user = new User();
		user.setBannerId("B00333111");
		assertTrue(user.getBannerId().equals("B00333111"));
	}

	@Test
	void testSetBannerId() {
		User user = new User();
		user.setBannerId("B00333111");
		assertTrue(user.getBannerId().equals("B00333111"));
	}

	@Test
	void testGetEmail() {
		User user = new User();
		user.setEmail("alex.gomez@dal.ca");
		assertTrue(user.getEmail().equals("alex.gomez@dal.ca"));
	}

	@Test
	void testSetEmail() {
		User user = new User();
		user.setEmail("alex.gomez@dal.ca");
		assertTrue(user.getEmail().equals("alex.gomez@dal.ca"));
	}

	@Test
	void testGetPassword() {
		User user = new User();
		user.setPassword("abc");
		assertTrue(user.getPassword().equals("abc"));
	}

	@Test
	void testSetPassword() {
		User user = new User();
		user.setPassword("abc");
		assertTrue(user.getPassword().equals("abc"));
	}

	@Test
	void testGetConfirmPassword() {
		User user = new User();
		user.setConfirmPassword("abc");
		assertTrue(user.getConfirmPassword().equals("abc"));
	}

	@Test
	void testSetConfirmPassword() {
		User user = new User();
		user.setConfirmPassword("abc");
		assertTrue(user.getConfirmPassword().equals("abc"));
	}

	@Test
	void testGetUser_type() {
		User user = new User();
		user.setUserType("G");
		assertTrue(user.getUserType().equals("G"));
	}

	@Test
	void testSetUser_type() {
		User user = new User();
		user.setUserType("G");
		assertTrue(user.getUserType().equals("G"));
	}

}

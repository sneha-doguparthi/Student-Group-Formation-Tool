package com.asdc.group6.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

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

}

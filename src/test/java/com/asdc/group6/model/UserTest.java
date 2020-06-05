package com.asdc.group6.model;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.asdc.group6.Models.User;

public class UserTest {

	@Test
	void testGetFirstName() {
		User user = new User();
		user.setFirstName("Bob");
		assertTrue(user.getFirstName().equals("Bob"));
	}

	@Test
	void testSetFirstName() {
		User user = new User();
		user.setFirstName("Bob");
		assertTrue(user.getFirstName().equals("Bob"));
	}

	@Test
	void testGetLastName() {
		User u = new User();

		u.setLastName("Bob");
		assertTrue(u.getLastName().equals("Bob"));
	}

	@Test
	void testSetLastName() {
		User user = new User();
		user.setLastName("Bob");
		assertTrue(user.getLastName().equals("Bob"));
	}

	@Test
	void testGetBannerId() {
		User user = new User();
		user.setBannerId("B00123456");
		assertTrue(user.getBannerId().equals("B00123456"));
	}

	@Test
	void testSetBannerId() {
		User user = new User();
		user.setBannerId("B00123456");
		assertTrue(user.getBannerId().equals("B00123456"));
	}

	@Test
	void testGetEmail() {
		User user = new User();
		user.setEmail("test@gmail.com");
		assertTrue(user.getEmail().equals("test@gmail.com"));
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

	@Test
	void testGetUserType() {
		User user = new User();
		user.setUserType("S");
		assertTrue(user.getUserType().equals("S"));
	}

	@Test
	void testSetUserType() {
		User user = new User();
		user.setUserType("S");
		assertTrue(user.getUserType().equals("S"));
	}
}

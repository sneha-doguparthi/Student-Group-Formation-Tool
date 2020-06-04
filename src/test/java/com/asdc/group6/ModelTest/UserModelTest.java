package com.asdc.group6.ModelTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.asdc.group6.Models.User;

public class UserModelTest {

	@Test
	void testGetFirstName() {
		User user = new User();
		user.setFirstName("Upendra");
		assertTrue(user.getFirstName().equals("Upendra"));
	}

	@Test
	void testSetFirstName() {
		User user = new User();
		user.setFirstName("Upendra");
		assertTrue(user.getFirstName().equals("Upendra"));
	}

	@Test
	void testGetLastName() {
		User u = new User();
		u.setLastName("Parsad");
		assertTrue(u.getLastName().equals("Parsad"));
	}

	@Test
	void testSetLastName() {
		User user = new User();
		user.setLastName("Parsad");
		assertTrue(user.getLastName().equals("Parsad"));
	}

	@Test
	void testGetBannerId() {
		User user = new User();
		user.setBannerId("B00838095");
		assertTrue(user.getBannerId().equals("B00838095"));
	}

	@Test
	void testSetBannerId() {
		User user = new User();
		user.setBannerId("B00838095");
		assertTrue(user.getBannerId().equals("B00838095"));
	}

	@Test
	void testGetEmail() {
		User user = new User();
		user.setEmail("upendra@dal.ca");
		assertTrue(user.getEmail().equals("upendra@dal.ca"));
	}

	@Test
	void testSetEmail() {
		User user = new User();
		user.setEmail("upendra@dal.ca");
		assertTrue(user.getEmail().equals("upendra@dal.ca"));
	}

}

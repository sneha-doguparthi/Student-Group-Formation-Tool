package com.asdc.group6.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.asdc.group6.Models.Association;

public class AssociationTest {

	@Test
	void testGetRegistrationId() {
		Association association = new Association();
		association.setRegistrationId(1);
		assertTrue(association.getRegistrationId().equals(1));
	}
	
	@Test
	void testSetRegistrationId() {
		Association association = new Association();
		association.setRegistrationId(2);
		assertTrue(association.getRegistrationId().equals(2));
	}
	
	@Test
	void testGetUserId() {
		Association association = new Association();
		association.setUserId(3);
		assertTrue(association.getUserId().equals(3));
	}
	
	@Test
	void testSetUserId() {
		Association association = new Association();
		association.setUserId(4);
		assertTrue(association.getUserId().equals(4));
	}
	
	@Test
	void testGetCourseId() {
		Association association = new Association();
		association.setCourseId(5);
		assertTrue(association.getCourseId().equals(5));
	}
	
	@Test
	void testSetCourseId() {
		Association association = new Association();
		association.setCourseId(6);
		assertTrue(association.getCourseId().equals(6));
	}

	@Test
	void testGetRoleId() {
		Association association = new Association();
		association.setRoleId("7");
		assertTrue(association.getRoleId().equals("7"));
	}
	
	@Test
	void testSetRoleId() {
		Association association = new Association();
		association.setRoleId("8");
		assertTrue(association.getRoleId().equals("8"));
	}
}

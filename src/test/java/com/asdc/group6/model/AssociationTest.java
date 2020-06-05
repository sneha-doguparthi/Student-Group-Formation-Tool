package com.asdc.group6.Model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.asdc.group6.Models.Association;

public class AssociationTest {

	@Test
	void testGetRegistrationId() {
		Association association = new Association();
		association.setRegistrationId(2);
		assertTrue(association.getRegistrationId().equals(2));
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
		association.setUserId(12);
		assertTrue(association.getUserId().equals(12));
	}
	
	@Test
	void testSetUserId() {
		Association association = new Association();
		association.setUserId(12);
		assertTrue(association.getUserId().equals(12));
	}
	
	@Test
	void testGetCourseId() {
		Association association = new Association();
		association.setCourseId(3);
		assertTrue(association.getCourseId().equals(3));
	}
	
	@Test
	void testSetCourseId() {
		Association association = new Association();
		association.setCourseId(3);
		assertTrue(association.getCourseId().equals(3));
	}
	
	@Test
	void testGetRoleId() {
		Association association = new Association();
		association.setRoleId("5");
		assertTrue(association.getRoleId().equals("5"));
	}
	
	@Test
	void testSetRoleId() {
		Association association = new Association();
		association.setRoleId("5");
		assertTrue(association.getRoleId().equals("5"));
	}
}

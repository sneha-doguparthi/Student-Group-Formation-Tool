package com.asdc.group6.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.asdc.group6.Models.Role;

public class RoleTest {

	@Test
	void testGetRoleId() {
		Role role = new Role();
		role.setRoleId("4");
		assertTrue(role.getRoleId().equals("4"));
	}
	
	@Test
	void testSetRoleId() {
		Role role = new Role();
		role.setRoleId("4");
		assertTrue(role.getRoleId().equals("4"));
	}
	
	@Test
	void testGetRoleName() {
		Role role = new Role();
		role.setRoleName("Student");
		assertTrue(role.getRoleName().equals("Student"));
	}
	
	@Test
	void testSetRoleName() {
		Role role = new Role();
		role.setRoleName("Student");
		assertTrue(role.getRoleName().equals("Student"));
	}
}

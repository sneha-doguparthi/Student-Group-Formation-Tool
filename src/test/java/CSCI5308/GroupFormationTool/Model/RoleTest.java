package CSCI5308.GroupFormationTool.Model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RoleTest {

	@Test
	void testGetRoleId() {
		Role role = new Role();
		role.setRoleId(4);
		assertTrue(role.getRoleId().equals(4));
	}

	@Test
	void testSetRoleId() {
		Role role = new Role();
		role.setRoleId(4);
		assertTrue(role.getRoleId().equals(4));
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

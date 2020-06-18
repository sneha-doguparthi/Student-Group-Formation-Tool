package CSCI5308.GroupFormationTool.Model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PasswordHistoryTest {

	@Test
	void testGetId() {
		PasswordHistory passwordHistory = new PasswordHistory();
		passwordHistory.setId(12);
		assertTrue(passwordHistory.getId().equals(12));
	}

	@Test
	void testSetId() {
		PasswordHistory passwordHistory = new PasswordHistory();
		passwordHistory.setId(14);
		assertTrue(passwordHistory.getId().equals(14));
	}

	@Test
	void testGetEmail() {
		PasswordHistory passwordHistory = new PasswordHistory();
		passwordHistory.setEmail("test@gmail.com");
		assertTrue(passwordHistory.getEmail().equals("test@gmail.com"));
	}

	@Test
	void testSetEmail() {
		PasswordHistory passwordHistory = new PasswordHistory();
		passwordHistory.setEmail("test@dal.com");
		assertTrue(passwordHistory.getEmail().equals("test@dal.com"));
	}

	@Test
	void testGetPassword() {
		PasswordHistory passwordHistory = new PasswordHistory();
		passwordHistory.setPassword("test_password");
		assertTrue(passwordHistory.getPassword().equals("test_password"));
	}

	@Test
	void testSetPassword() {
		PasswordHistory passwordHistory = new PasswordHistory();
		passwordHistory.setPassword("test_password");
		assertTrue(passwordHistory.getPassword().equals("test_password"));
	}
}

package CSCI5308.GroupFormationTool.Profile.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Model.PasswordHistory;

public class PasswordHistoryDaoImplTest {

	IPasswordHistoryDao passwordHistoryDaoImplMock = mock(PasswordHistoryDaoImpl.class);

	@Test
	void testInsertTrue() {
		String email = "test@gmail.com";
		String password = "test_password";

		when(passwordHistoryDaoImplMock.insert(email, password)).thenReturn(true);
		assertTrue(passwordHistoryDaoImplMock.insert(email, password), "Error");
		verify(passwordHistoryDaoImplMock).insert(email, password);
	}

	@Test
	void testInsertFalse() {
		String email = "test@gmail.com";
		String password = "test_password";

		when(passwordHistoryDaoImplMock.insert(email, password)).thenReturn(false);
		assertFalse(passwordHistoryDaoImplMock.insert(email, password), "Error");
		verify(passwordHistoryDaoImplMock).insert(email, password);
	}

	@Test
	void testFetch() {
		String email = "test@gmail.com";
		int limit = 1;

		ArrayList<PasswordHistory> list = new ArrayList<>();

		PasswordHistory passwordHistory = new PasswordHistory();
		passwordHistory.setId(2);
		passwordHistory.setEmail(email);
		passwordHistory.setPassword("test_password");

		list.add(passwordHistory);

		when(passwordHistoryDaoImplMock.fetch(email, limit)).thenReturn(list);
		assertEquals(passwordHistoryDaoImplMock.fetch(email, limit), list, "Error");
		verify(passwordHistoryDaoImplMock).fetch(email, limit);
	}
}

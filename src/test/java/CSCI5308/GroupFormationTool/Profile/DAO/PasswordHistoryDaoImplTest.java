package CSCI5308.GroupFormationTool.Profile.DAO;

import CSCI5308.GroupFormationTool.Model.PasswordHistory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PasswordHistoryDaoImplTest {

	PasswordHistoryDao passwordHistoryDaoImplMock = mock(PasswordHistoryDaoImpl.class);

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

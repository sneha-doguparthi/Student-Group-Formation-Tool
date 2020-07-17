package CSCI5308.GroupFormationTool.Course.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Profile.IUser;
import CSCI5308.GroupFormationTool.Profile.UserFactory;
import CSCI5308.GroupFormationTool.Profile.UserObjectFactory;

public class AssignTaServiceImplTest {

	IAssignTaService assignTaServiceImplMock = mock(AssignTaServiceImpl.class);

	@Test
	void testGetAllUsers() {

		ArrayList<IUser> list = new ArrayList<>();

		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setBannerId("B00851234");
		user.setFirstName("Bob");
		user.setLastName("Builder");
		user.setPassword("bobpassword");
		user.setUserType("S");

		list.add(user);

		when(assignTaServiceImplMock.getAllUsers()).thenReturn(list);
		assertEquals(assignTaServiceImplMock.getAllUsers(), list, "No user data present in database");
		verify(assignTaServiceImplMock).getAllUsers();
	}

	@Test
	void testAssignTaTrue() {

		when(assignTaServiceImplMock.assignTa("1", 2)).thenReturn(true);
		assertTrue(assignTaServiceImplMock.assignTa("1", 2), "Ta not assigned");
		verify(assignTaServiceImplMock).assignTa("1", 2);

	}

	@Test
	void testAssignTaFalse() {

		when(assignTaServiceImplMock.assignTa("1", 2)).thenReturn(false);
		assertFalse(assignTaServiceImplMock.assignTa("1", 2), "Ta not assigned");
		verify(assignTaServiceImplMock).assignTa("1", 2);

	}
}

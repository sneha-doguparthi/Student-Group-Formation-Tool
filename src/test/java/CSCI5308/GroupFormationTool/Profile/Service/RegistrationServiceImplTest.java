package CSCI5308.GroupFormationTool.Profile.Service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Model.User;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RegistrationServiceImplTest {

	RegistrationService registrationServiceImplMock = mock(RegistrationServiceImpl.class);

	@Test
	void testRegisterUserServiceTrue() {

		User user = new User();
		user.setBannerId("B00851234");
		user.setFirstName("Bob");
		user.setLastName("Builder");
		user.setPassword("bobpassword");
		user.setUserType("S");

		when(registrationServiceImplMock.registerUserService(user)).thenReturn(true);
		assertTrue(registrationServiceImplMock.registerUserService(user), "Error");
		verify(registrationServiceImplMock).registerUserService(user);
	}

	@Test
	void testRegisterUserServiceFalse() {

		User user = new User();
		user.setBannerId("B00851234");
		user.setFirstName("Bob");
		user.setLastName("Builder");
		user.setPassword("bobpassword");
		user.setUserType("S");

		when(registrationServiceImplMock.registerUserService(user)).thenReturn(false);
		assertFalse(registrationServiceImplMock.registerUserService(user), "Error");
		verify(registrationServiceImplMock).registerUserService(user);
	}
}

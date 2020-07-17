package CSCI5308.GroupFormationTool.Profile.Service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Profile.IUser;
import CSCI5308.GroupFormationTool.Profile.UserFactory;
import CSCI5308.GroupFormationTool.Profile.UserObjectFactory;

public class RegistrationServiceImplTest {

	IRegistrationService registrationServiceImplMock = mock(RegistrationServiceImpl.class);

	@Test
	void testRegisterUserServiceTrue() {

		IUser user = UserFactory.userObject(new UserObjectFactory());
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

		IUser user = UserFactory.userObject(new UserObjectFactory());
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

package com.asdc.group6.Profile.Registration.DAO;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import com.asdc.group6.Models.User;

class RegistrationDaoImplTest {

	RegistrationDao registrationDao = mock(RegistrationDaoImpl.class);

	@Test
	void testRegisterUser() {
		User user = new User();
		user.setBannerId("B00222111");
		user.setFirstName("Alex");
		user.setLastName("Gomez");
		user.setEmail("alex.Gomez@dal.ca");

		when(registrationDao.registerUser(user)).thenReturn(true);
		assertTrue(registrationDao.registerUser(user), "Error in creating usser");
		verify(registrationDao).registerUser(user);

	}

}

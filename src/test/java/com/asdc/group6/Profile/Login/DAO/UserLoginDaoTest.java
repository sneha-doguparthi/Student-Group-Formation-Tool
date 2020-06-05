package com.asdc.group6.Profile.Login.DAO;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import com.asdc.group6.Models.User;

class UserLoginDaoTest {
	UserLoginDao userLoginDao = mock(UserLoginDaoImpl.class);

	@Test
	void testCheckAccess() {
		User user = new User();
		user.setEmail("alex.gomez@dal.ca");
		user.setPassword("1234");

		when(userLoginDao.checkAccess(user)).thenReturn(true);
		assertTrue(userLoginDao.checkAccess(user), "Error in retrieving usser");
		verify(userLoginDao).checkAccess(user);
	}

}

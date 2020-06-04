package com.asdc.group6.Profile.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import com.asdc.group6.Models.User;
import com.asdc.group6.Profile.Login.DAO.UserDaoImpl;

class UserDaoImplTest {

	UserDaoImpl userDaoImplMock = mock(UserDaoImpl.class);
	
	@Test
	void testGetAll() {
		ArrayList<User> list = new ArrayList<>();
		
		User user = new User();
		user.setBannerId("B00851234");
		user.setFirstName("Bob");
		user.setLastName("Builder");
		user.setPassword("bobpassword");
		user.setUserType("S");
		
		list.add(user);
		
		when(userDaoImplMock.getAll()).thenReturn(list);
		assertEquals(userDaoImplMock.getAll(), list,"No user data present in database");
		verify(userDaoImplMock).getAll();
	}
	
	@Test
	void testGetByEmail() {
		ArrayList<User> list = new ArrayList<>();
		
		User user = new User();
		user.setBannerId("B00851234");
		user.setFirstName("Bob");
		user.setLastName("Builder");
		user.setEmail("test@gmail.com");
		user.setPassword("bobpassword");
		user.setUserType("S");
		
		list.add(user);
		
		when(userDaoImplMock.getByEmail("test@gmail.com")).thenReturn(list);
		assertEquals(userDaoImplMock.getByEmail("test@gmail.com"), list,"No data present in database");
		verify(userDaoImplMock).getByEmail("test@gmail.com");
	}
	
	@Test
	void testUpdate() {
		
		User user = new User();
		user.setBannerId("B00851234");
		user.setFirstName("Bob");
		user.setLastName("Builder");
		user.setEmail("test@gmail.com");
		user.setPassword("bobpassword");
		user.setUserType("S");
		
		when(userDaoImplMock.update(user)).thenReturn(true);
		assertTrue(userDaoImplMock.update(user), "Error while updating user information");
		verify(userDaoImplMock).update(user);
	}
}

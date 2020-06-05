package com.asdc.group6.CourseAdmin.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import com.asdc.group6.Models.User;

public class UserDaoImplTest {

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

}

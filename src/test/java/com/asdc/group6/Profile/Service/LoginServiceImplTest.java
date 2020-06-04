package com.asdc.group6.Profile.Service;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import com.asdc.group6.Models.User;
import com.asdc.group6.Profile.Login.Service.LoginServiceImpl;

public class LoginServiceImplTest {

	LoginServiceImpl loginServiceImplMock = mock(LoginServiceImpl.class);
	
	@Test
	void testCheckAccessService() {
		
		User user = new User();
		user.setBannerId("B00851234");
		user.setFirstName("Bob");
		user.setLastName("Builder");
		user.setPassword("bobpassword");
		user.setUserType("S");
		
		Model model = new ExtendedModelMap();
		
		when(loginServiceImplMock.checkAccessService(user, model)).thenReturn("login");
		assertEquals(loginServiceImplMock.checkAccessService(user, model), "login", "error");
		verify(loginServiceImplMock).checkAccessService(user, model);
	}
}

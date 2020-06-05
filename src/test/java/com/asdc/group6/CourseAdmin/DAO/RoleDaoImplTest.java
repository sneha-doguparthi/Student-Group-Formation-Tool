package com.asdc.group6.CourseAdmin.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.asdc.group6.Models.Role;

public class RoleDaoImplTest {

	RoleDaoImpl roleDaoImplMock = mock(RoleDaoImpl.class);
	
	@Test
	void testFindByName() {
		
		ArrayList<Role> list = new ArrayList<>();
		
		Role role = new Role();
		role.setRoleId("1");
		role.setRoleName("Student");
		
		list.add(role);
		
		when(roleDaoImplMock.findByName("test@gmail.com")).thenReturn(list);
		assertEquals(roleDaoImplMock.findByName("test@gmail.com"), list, "No result found");
		verify(roleDaoImplMock).findByName("test@gmail.com");
	}
}

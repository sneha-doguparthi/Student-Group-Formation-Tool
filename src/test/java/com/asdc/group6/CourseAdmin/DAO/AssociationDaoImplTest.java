package com.asdc.group6.CourseAdmin.DAO;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

import com.asdc.group6.Models.Association;

public class AssociationDaoImplTest {

	AssociationDaoImpl associationDaoImplMock = mock(AssociationDaoImpl.class);
	
	@Test
	void testInsert() {
		
		Association association = new Association();
		association.setCourseId(1);
		association.setRegistrationId(2);
		association.setRoleId("3");
		association.setUserId(4);
		
		when(associationDaoImplMock.insert(association)).thenReturn(true);
		assertTrue(associationDaoImplMock.insert(association), "Error inserting association");
		verify(associationDaoImplMock).insert(association);
	}
}

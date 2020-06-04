package com.asdc.group6.Profile.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import com.asdc.group6.Models.Association;
import com.asdc.group6.Profile.Login.DAO.AssociationDaoImpl;

public class AssociationDaoImplTest {

	AssociationDaoImpl associationDaoImplMock = mock(AssociationDaoImpl.class);
	
	@Test
	void testInsert() {
		
		Association association = new Association();
	
		association.setRegistrationId(1);
		association.setUserId(2);
		association.setRoleId("3");
		association.setCourseId(4);
		
		when(associationDaoImplMock.insert(association)).thenReturn(true);
		assertTrue(associationDaoImplMock.insert(association), "Error inserting association object");
		verify(associationDaoImplMock).insert(association);
	}
	
	@Test
	void testGetByUserId() {
		
		ArrayList<Association> list = new ArrayList<>();
		
		Association association = new Association();
		
		association.setRegistrationId(1);
		association.setUserId(2);
		association.setRoleId("3");
		association.setCourseId(4);
		
		list.add(association);
		
		when(associationDaoImplMock.getByUserId(2)).thenReturn(list);
		assertEquals(associationDaoImplMock.getByUserId(2), list, "Error getting association object");
		verify(associationDaoImplMock).getByUserId(2);
	}
}

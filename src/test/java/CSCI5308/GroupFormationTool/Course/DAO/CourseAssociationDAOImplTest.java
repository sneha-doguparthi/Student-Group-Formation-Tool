package CSCI5308.GroupFormationTool.Course.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class CourseAssociationDAOImplTest {

	ICourseAssociationDao courseAssociationDaoImplMock = mock(CourseAssociationDAOImpl.class);

	@Test
	void testGetUserID() {

		ArrayList<Integer> result = new ArrayList<>();

		result.add(0, 5);

		when(courseAssociationDaoImplMock.getUserID(1)).thenReturn(result);
		assertEquals(courseAssociationDaoImplMock.getUserID(1), result, "getUserID Test Failed");
		verify(courseAssociationDaoImplMock).getUserID(1);
	}

	@Test
	void testAddByUserID() {

		ArrayList<Integer> parameter = new ArrayList<>();

		parameter.add(1);

		when(courseAssociationDaoImplMock.addByUserID(parameter, 1)).thenReturn(true);
		assertTrue(courseAssociationDaoImplMock.addByUserID(parameter, 1), "addByUserID Test Failed");
		verify(courseAssociationDaoImplMock).addByUserID(parameter, 1);
	}

}

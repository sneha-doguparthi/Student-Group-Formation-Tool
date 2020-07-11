package CSCI5308.GroupFormationTool.Course.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Model.Role;
import CSCI5308.GroupFormationTool.Profile.DAO.IRoleDao;
import CSCI5308.GroupFormationTool.Profile.DAO.RoleDaoImpl;

public class RoleDaoImplTest {

	IRoleDao roleDaoImplMock = mock(RoleDaoImpl.class);

	@Test
	void testFindByName() {

		ArrayList<Role> list = new ArrayList<>();

		Role role = new Role();
		role.setRoleId(1);
		role.setRoleName("Student");

		list.add(role);

		when(roleDaoImplMock.findByName("test@gmail.com")).thenReturn(list);
		assertEquals(roleDaoImplMock.findByName("test@gmail.com"), list, "No result found");
		verify(roleDaoImplMock).findByName("test@gmail.com");
	}
}

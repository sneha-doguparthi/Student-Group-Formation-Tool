package CSCI5308.GroupFormationTool.Course.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.Profile.DAO.IUserDao;
import CSCI5308.GroupFormationTool.Profile.DAO.UserDaoImpl;

public class UserDaoImplTest {

	IUserDao userDaoImplMock = mock(UserDaoImpl.class);

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
		assertEquals(userDaoImplMock.getAll(), list, "No user data present in database");
		verify(userDaoImplMock).getAll();
	}

}

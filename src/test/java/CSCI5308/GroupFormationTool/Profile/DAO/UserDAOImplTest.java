package CSCI5308.GroupFormationTool.Profile.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Model.Student;
import CSCI5308.GroupFormationTool.Profile.IUser;
import CSCI5308.GroupFormationTool.Profile.UserFactory;
import CSCI5308.GroupFormationTool.Profile.UserObjectFactory;

public class UserDAOImplTest {

	IUserDao userDaoImplMock = mock(UserDaoImpl.class);

	@Test
	void testGetByUserID() {

		ArrayList<IUser> userList = new ArrayList<>();
		ArrayList<Integer> parameter = new ArrayList<>();

		parameter.add(0, 5);

		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setUserId(5);
		user.setBannerId("B00123456");
		user.setFirstName("Tony");
		user.setLastName("Stark");
		user.setEmail("ts@marveldal.ca");
		user.setPassword("jarvisloggedmein");
		user.setUserType("S");

		userList.add(user);

		when(userDaoImplMock.getUserByUserID(parameter)).thenReturn(userList);
		assertEquals(userDaoImplMock.getUserByUserID(parameter), userList, "getByUserID Test Failed");
		verify(userDaoImplMock).getUserByUserID(parameter);
	}

	@Test
	void testGetAll() {

		ArrayList<IUser> userList = new ArrayList<>();

		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setUserId(5);
		user.setBannerId("B00123456");
		user.setFirstName("Tony");
		user.setLastName("Stark");
		user.setEmail("ts@marveldal.ca");
		user.setPassword("jarvisloggedmein");
		user.setUserType("S");

		userList.add(user);

		when(userDaoImplMock.getAll()).thenReturn(userList);
		assertEquals(userDaoImplMock.getAll(), userList, "getAll Test Failed");
		verify(userDaoImplMock).getAll();
	}

	@Test
	void testGetUserID() {

		List<Student> studentList = new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<>();

		Student student = new Student();
		student.setbId("B00123456");
		student.setFirstName("Tony");
		student.setLastName("Stark");
		student.setEmail("ts@marveldal.ca");

		studentList.add(student);

		result.add(0, 5);

		when(userDaoImplMock.getUserID(studentList)).thenReturn(result);
		assertEquals(userDaoImplMock.getUserID(studentList), result, "getUserID Test Failed");
		verify(userDaoImplMock).getUserID(studentList);
	}

	@Test
	void testAddUser() {

		List<Student> studentList = new ArrayList<>();

		Student student = new Student();
		student.setbId("B00123456");
		student.setFirstName("Tony");
		student.setLastName("Stark");
		student.setEmail("ts@marveldal.ca");

		studentList.add(student);

		when(userDaoImplMock.addUser(studentList)).thenReturn(true);
		assertTrue(userDaoImplMock.addUser(studentList), "addUser Test Failed");
		verify(userDaoImplMock).addUser(studentList);
	}

	@Test
	void testGetPassword() {

		List<Student> studentList = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();

		Student student = new Student();
		student.setbId("B00123456");
		student.setFirstName("Tony");
		student.setLastName("Stark");
		student.setEmail("ts@marveldal.ca");

		studentList.add(student);

		result.add(0, "jarvisloggedmein");

		when(userDaoImplMock.getPassword(studentList)).thenReturn(result);
		assertEquals(userDaoImplMock.getPassword(studentList), result, "getPassword Test Failed");
		verify(userDaoImplMock).getPassword(studentList);
	}

}

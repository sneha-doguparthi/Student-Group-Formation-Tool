package CSCI5308.GroupFormationTool.Course.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

public class GetStudentListServiceImplTest {

	IGetStudentListService getStudentListServiceImplMock = mock(GetStudentListServiceImpl.class);

	@Test
	void testGetNewToCourseStudentList() {

		List<Student> studentList = new ArrayList<>();
		ArrayList<IUser> userList = new ArrayList<>();
		List<Student> result = new ArrayList<>();

		Student student = new Student();
		student.setbId("B00123456");
		student.setFirstName("Tony");
		student.setLastName("Stark");
		student.setEmail("ts@marveldal.ca");
		studentList.add(student);

		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setUserId(5);
		user.setBannerId("B00123457");
		user.setFirstName("Captain");
		user.setLastName("America");
		user.setEmail("ca@marveldal.ca");
		user.setPassword("iamfrombrooklyn");
		user.setUserType("G");
		userList.add(user);

		result.add(student);

		when(getStudentListServiceImplMock.getNewToCourseStudentList(studentList, userList)).thenReturn(result);
		assertEquals(getStudentListServiceImplMock.getNewToCourseStudentList(studentList, userList), result,
				"getNewToCourseStudentList Test Failed");
		verify(getStudentListServiceImplMock).getNewToCourseStudentList(studentList, userList);
	}

	@Test
	void testGetNewToPortalStudentList() {

		List<Student> studentList = new ArrayList<>();
		ArrayList<IUser> userList = new ArrayList<>();
		List<Student> result = new ArrayList<>();

		Student student = new Student();
		student.setbId("B00123456");
		student.setFirstName("Tony");
		student.setLastName("Stark");
		student.setEmail("ts@marveldal.ca");
		studentList.add(student);

		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setUserId(5);
		user.setBannerId("B00123457");
		user.setFirstName("Captain");
		user.setLastName("America");
		user.setEmail("ca@marveldal.ca");
		user.setPassword("iamfrombrooklyn");
		user.setUserType("G");

		userList.add(user);

		result.add(student);

		when(getStudentListServiceImplMock.getNewToPortalStudentList(studentList, userList)).thenReturn(result);
		assertEquals(getStudentListServiceImplMock.getNewToPortalStudentList(studentList, userList), result,
				"getNewToPortalStudentList Test Failed");
		verify(getStudentListServiceImplMock).getNewToPortalStudentList(studentList, userList);
	}

}

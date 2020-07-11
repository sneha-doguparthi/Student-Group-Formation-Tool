package CSCI5308.GroupFormationTool.ToolAdmin.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import CSCI5308.GroupFormationTool.Course.CourseFactory;
import CSCI5308.GroupFormationTool.Course.CourseObjectFactory;
import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.Profile.IUser;
import CSCI5308.GroupFormationTool.Profile.UserFactory;
import CSCI5308.GroupFormationTool.Profile.UserObjectFactory;
import CSCI5308.GroupFormationTool.Utilities.ApplicationConstants;

public class IAssignInstructorServiceTest {
	IAssignInstructorService assignInstructorService = mock(AssignInstructorServiceImpl.class);
	ICourse course;
	IUser user;
	ArrayList<IUser> userList = new ArrayList<>();

	public IAssignInstructorServiceTest() {
		user = UserFactory.userObject(new UserObjectFactory());
		user.setFirstName("James");
		user.setLastName("Smith");
		user.setEmail("james@dal.ca");
		userList.add(user);

		course = CourseFactory.courseObject(new CourseObjectFactory());
		course.setCourseId(1);
		course.setCourseCode("6708");
		course.setCourseName("Adv. Web Development");
	}

	@Test
	public void testGetUserList() {
		when(assignInstructorService.getUserList()).thenAnswer(new Answer<ArrayList<IUser>>() {
			@Override
			public ArrayList<IUser> answer(InvocationOnMock invocation) throws Throwable {
				return userList;
			}
		});
		assertEquals(assignInstructorService.getUserList(), userList);
		verify(assignInstructorService).getUserList();
	}

	@Test
	public void testAssignRoleToUser() {
		when(assignInstructorService.assignRoleToUser(user, course.getCourseCode()))
				.thenReturn(ApplicationConstants.COURSE_ADDED);
		assertEquals(assignInstructorService.assignRoleToUser(user, course.getCourseCode()),
				ApplicationConstants.COURSE_ADDED);
		verify(assignInstructorService).assignRoleToUser(user, course.getCourseCode());
	}
}

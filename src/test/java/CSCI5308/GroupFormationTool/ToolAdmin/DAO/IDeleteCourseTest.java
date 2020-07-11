package CSCI5308.GroupFormationTool.ToolAdmin.DAO;

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

public class IDeleteCourseTest {
	IDeleteCourse deleteCourse = mock(DeleteCourseImpl.class);
	ICourse course;
	ArrayList<String> coursesToDelete = new ArrayList<>();
	ArrayList<String> deleteResult = new ArrayList<>();

	public IDeleteCourseTest() {
		course = CourseFactory.courseObject(new CourseObjectFactory());
		course.setCourseId(1);
		course.setCourseCode("6708");
		course.setCourseName("Adv. Web Development");
		coursesToDelete.add(course.getCourseCode());
		deleteResult.add(course.getCourseCode().concat(" deleted successfully!"));
	}

	@Test
	public void testDeleteCourse() {
		when(deleteCourse.deleteCourse(coursesToDelete)).thenAnswer(new Answer<ArrayList<String>>() {
			@Override
			public ArrayList<String> answer(InvocationOnMock invocation) throws Throwable {
				Object[] arguments = invocation.getArguments();
				if (arguments != null && arguments.length > 0 && arguments[0] != null) {
					@SuppressWarnings("unchecked")
					ArrayList<String> deleteCourseList = (ArrayList<String>) arguments[0];
					ArrayList<String> result = new ArrayList<>();
					for (int i = 0; i < deleteCourseList.size(); i++) {
						result.add(deleteCourseList.get(i) + " deleted successfully!");
					}
					return result;
				}
				return null;
			}
		});
		assertEquals(deleteCourse.deleteCourse(coursesToDelete), deleteResult);
		verify(deleteCourse).deleteCourse(coursesToDelete);
	}
}

package CSCI5308.GroupFormationTool.ToolAdmin.DAO;

public class ToolAdminDaoFactory extends ToolAdminDaoAbstractFactory {

	private static ToolAdminDaoAbstractFactory toolAdminDaoFactory;
	private IAddCourse addCourse;
	private IAssignInstructor assignInstructor;
	private IViewCourses viewCourses;
	private IDeleteCourse deleteCourse;

	private ToolAdminDaoFactory() {
	}

	public static ToolAdminDaoAbstractFactory instance() {
		if (null == toolAdminDaoFactory) {
			toolAdminDaoFactory = new ToolAdminDaoFactory();
		}
		return toolAdminDaoFactory;
	}

	@Override
	public IAddCourse addCourseDao() {
		if (null == addCourse) {
			addCourse = new AddCourseImpl();
		}
		return addCourse;
	}

	@Override
	public IAssignInstructor assignInstructorDao() {
		if (null == assignInstructor) {
			assignInstructor = new AssignInstructorImpl();
		}
		return assignInstructor;
	}

	@Override
	public IViewCourses viewCoursesDao() {
		if (null == viewCourses) {
			viewCourses = new ViewCoursesImpl();
		}
		return viewCourses;
	}

	@Override
	public IDeleteCourse deleteCourseDao() {
		if (null == deleteCourse) {
			deleteCourse = new DeleteCourseImpl();
		}
		return deleteCourse;
	}
}

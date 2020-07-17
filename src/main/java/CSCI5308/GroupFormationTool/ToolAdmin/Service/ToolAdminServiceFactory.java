package CSCI5308.GroupFormationTool.ToolAdmin.Service;

public class ToolAdminServiceFactory extends ToolAdminServiceAbstractFactory {

	private static ToolAdminServiceFactory instance;
	private IAddCourseService addCourseService;
	private IDeleteCourseService deleteCourseService;
	private IViewCoursesService viewCoursesService;
	private IAssignInstructorService assignInstructorService;

	private ToolAdminServiceFactory() {
	}

	public static ToolAdminServiceFactory instance() {
		if (null == instance) {
			instance = new ToolAdminServiceFactory();
		}
		return instance;
	}

	@Override
	public IAddCourseService addCourseService() {
		if (null == addCourseService) {
			addCourseService = new AddCourseServiceImpl();
		}
		return addCourseService;
	}

	@Override
	public IDeleteCourseService deleteCourseService() {
		if (null == deleteCourseService) {
			deleteCourseService = new DeleteCourseServiceImpl();
		}
		return deleteCourseService;
	}

	@Override
	public IViewCoursesService viewCourseService() {
		if (null == viewCoursesService) {
			viewCoursesService = new ViewCoursesServiceImpl();
		}
		return viewCoursesService;
	}

	@Override
	public IAssignInstructorService assignInstructorService() {
		if (null == assignInstructorService) {
			assignInstructorService = new AssignInstructorServiceImpl();
		}
		return assignInstructorService;
	}

}

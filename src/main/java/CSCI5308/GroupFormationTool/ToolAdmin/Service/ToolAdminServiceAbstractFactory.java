package CSCI5308.GroupFormationTool.ToolAdmin.Service;

public abstract class ToolAdminServiceAbstractFactory {
	public abstract IAddCourseService addCourseService();

	public abstract IDeleteCourseService deleteCourseService();

	public abstract IViewCoursesService viewCourseService();

	public abstract IAssignInstructorService assignInstructorService();
}

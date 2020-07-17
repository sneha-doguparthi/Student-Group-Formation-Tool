package CSCI5308.GroupFormationTool.ToolAdmin.DAO;

public abstract class ToolAdminDaoAbstractFactory {

	public abstract IAddCourse addCourseDao();

	public abstract IAssignInstructor assignInstructorDao();

	public abstract IViewCourses viewCoursesDao();

	public abstract IDeleteCourse deleteCourseDao();

}

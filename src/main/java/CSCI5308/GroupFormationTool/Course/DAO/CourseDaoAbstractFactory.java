package CSCI5308.GroupFormationTool.Course.DAO;

public abstract class CourseDaoAbstractFactory {
	public abstract ICourseDao courseDao();

	public abstract ICourseAssociationDao courseAssociationDao();
}

package CSCI5308.GroupFormationTool.Course.DAO;

public class CourseDaoFactory extends CourseDaoAbstractFactory {

	private static CourseDaoFactory instance = null;
	private ICourseDao courseDao;
	private ICourseAssociationDao courseAssociationDao;
	private ICourseSurveyDao courseSurveyDao;

	private CourseDaoFactory() {

	}

	public static CourseDaoFactory instance() {
		if (null == instance) {
			instance = new CourseDaoFactory();
		}
		return instance;
	}

	@Override
	public ICourseDao courseDao() {
		if (null == courseDao) {
			courseDao = new CourseDaoImpl();
		}
		return courseDao;
	}

	@Override
	public ICourseAssociationDao courseAssociationDao() {
		if (null == courseAssociationDao) {
			courseAssociationDao = new CourseAssociationDAOImpl();
		}
		return courseAssociationDao;
	}

	@Override
	public ICourseSurveyDao courseSurveyDao() {
		if (null == courseSurveyDao) {
			courseSurveyDao = new CourseSurveyDaoImpl();
		}
		return courseSurveyDao;
	}

}

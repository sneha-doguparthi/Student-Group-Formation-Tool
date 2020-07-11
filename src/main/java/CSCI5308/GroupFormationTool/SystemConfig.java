package CSCI5308.GroupFormationTool;

import CSCI5308.GroupFormationTool.Course.DAO.CourseAssociationDAO;
import CSCI5308.GroupFormationTool.Course.DAO.CourseAssociationDAOImpl;
import CSCI5308.GroupFormationTool.Course.DAO.CourseDao;
import CSCI5308.GroupFormationTool.Course.DAO.CourseDaoImpl;
import CSCI5308.GroupFormationTool.Course.Service.AssignTaService;
import CSCI5308.GroupFormationTool.Course.Service.AssignTaServiceImpl;
import CSCI5308.GroupFormationTool.Course.Service.GetStudentListService;
import CSCI5308.GroupFormationTool.Course.Service.GetStudentListServiceImpl;
import CSCI5308.GroupFormationTool.Course.Service.SendInvitationEmailService;
import CSCI5308.GroupFormationTool.Course.Service.SendInvitationEmailServiceImpl;
import CSCI5308.GroupFormationTool.Course.Service.UploadCsvFileService;
import CSCI5308.GroupFormationTool.Course.Service.UploadCsvFileServiceImpl;
import CSCI5308.GroupFormationTool.DBUtil.DefaultDatabaseConfiguration;
import CSCI5308.GroupFormationTool.DBUtil.IDatabaseConfiguration;
import CSCI5308.GroupFormationTool.Profile.DAO.OtpDao;
import CSCI5308.GroupFormationTool.Profile.DAO.OtpDaoImpl;
import CSCI5308.GroupFormationTool.Profile.DAO.PasswordHistoryDao;
import CSCI5308.GroupFormationTool.Profile.DAO.PasswordHistoryDaoImpl;
import CSCI5308.GroupFormationTool.Profile.DAO.RoleDao;
import CSCI5308.GroupFormationTool.Profile.DAO.RoleDaoImpl;
import CSCI5308.GroupFormationTool.Profile.DAO.UserDao;
import CSCI5308.GroupFormationTool.Profile.DAO.UserDaoImpl;
import CSCI5308.GroupFormationTool.Profile.Service.LoginService;
import CSCI5308.GroupFormationTool.Profile.Service.LoginServiceImpl;
import CSCI5308.GroupFormationTool.Profile.Service.MailService;
import CSCI5308.GroupFormationTool.Profile.Service.MailServiceImpl;
import CSCI5308.GroupFormationTool.Profile.Service.OtpService;
import CSCI5308.GroupFormationTool.Profile.Service.OtpServiceImpl;
import CSCI5308.GroupFormationTool.Profile.Service.RegistrationService;
import CSCI5308.GroupFormationTool.Profile.Service.RegistrationServiceImpl;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.DeleteQuestionDAO;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.DeleteQuestionDAOImpl;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.FetchQuestionDAO;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.FetchQuestionDAOImpl;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.StoreMcqOptionsDAO;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.StoreMcqOptionsDAOImpl;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.StoreQuestionDAO;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.StoreQuestionDAOImpl;
import CSCI5308.GroupFormationTool.QuestionManager.Service.DeleteQuestionService;
import CSCI5308.GroupFormationTool.QuestionManager.Service.DeleteQuestionServiceImpl;
import CSCI5308.GroupFormationTool.QuestionManager.Service.FetchQuestionService;
import CSCI5308.GroupFormationTool.QuestionManager.Service.FetchQuestionServiceImpl;
import CSCI5308.GroupFormationTool.QuestionManager.Service.SplitMcqAnswerService;
import CSCI5308.GroupFormationTool.QuestionManager.Service.SplitMcqAnswerServiceImpl;
import CSCI5308.GroupFormationTool.QuestionManager.Service.StoreMcqOptionService;
import CSCI5308.GroupFormationTool.QuestionManager.Service.StoreMcqOptionServiceImpl;
import CSCI5308.GroupFormationTool.QuestionManager.Service.StoreQuestionService;
import CSCI5308.GroupFormationTool.QuestionManager.Service.StoreQuestionServiceImpl;
import CSCI5308.GroupFormationTool.Survey.DAO.GetQuestionsDAO;
import CSCI5308.GroupFormationTool.Survey.DAO.GetQuestionsDAOImpl;
import CSCI5308.GroupFormationTool.Survey.Service.GetQuestionsService;
import CSCI5308.GroupFormationTool.Survey.Service.GetQuestionsServiceImpl;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.AddCourse;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.AddCourseImpl;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.AssignInstructor;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.AssignInstructorImpl;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.DeleteCourse;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.DeleteCourseImpl;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.ViewCourses;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.ViewCoursesImpl;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.AddCourseService;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.AddCourseServiceImpl;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.AssignInstructorService;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.AssignInstructorServiceImpl;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.DeleteCourseService;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.DeleteCourseServiceImpl;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.ViewCoursesService;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.ViewCoursesServiceImpl;

public class SystemConfig {

	private static SystemConfig uniqueInstance = null;
	private IDatabaseConfiguration databaseConfiguration;
	private CourseDao courseDao;
	private CourseAssociationDAO courseAssociationDAO;
	private AssignTaService assignTaService;
	private GetStudentListService getStudentListService;
	private SendInvitationEmailService sendInvitationEmailService;
	private UploadCsvFileService uploadCsvFileService;
	private OtpDao otpDao;
	private PasswordHistoryDao passwordHistoryDao;
	private RoleDao roleDao;
	private UserDao userDao;
	private LoginService loginService;
	private MailService mailService;
	private OtpService otpService;
	private RegistrationService registrationService;
	private StoreMcqOptionsDAO storeMcqOptionsDAO;
	private StoreQuestionDAO storeQuestionDAO;
	private SplitMcqAnswerService splitMcqAnswerService;
	private StoreMcqOptionService storeMcqOptionService;
	private StoreQuestionService storeQuestionService;
	private AddCourse addCourse;
	private AssignInstructor assignInstructor;
	private DeleteCourse deleteCourse;
	private ViewCourses viewCourses;
	private AddCourseService addCourseService;
	private AssignInstructorService assignInstructorService;
	private DeleteCourseService deleteCourseService;
	private ViewCoursesService viewCoursesService;
	private FetchQuestionService fetchQuestionService;
	private DeleteQuestionService deleteQuestionService;
	private FetchQuestionDAO fetchQuestionDAO;
	private DeleteQuestionDAO deleteQuestionDAO;
	private GetQuestionsDAO getQuestionsDAO;
	private GetQuestionsService getQuestionsService;

	private SystemConfig() {
		databaseConfiguration = new DefaultDatabaseConfiguration();
		courseDao = new CourseDaoImpl();
		databaseConfiguration = new DefaultDatabaseConfiguration();
		courseDao = new CourseDaoImpl();
		courseAssociationDAO = new CourseAssociationDAOImpl();
		assignTaService = new AssignTaServiceImpl();
		getStudentListService = new GetStudentListServiceImpl();
		sendInvitationEmailService = new SendInvitationEmailServiceImpl();
		uploadCsvFileService = new UploadCsvFileServiceImpl();
		otpDao = new OtpDaoImpl();
		passwordHistoryDao = new PasswordHistoryDaoImpl();
		roleDao = new RoleDaoImpl();
		userDao = new UserDaoImpl();
		loginService = new LoginServiceImpl();
		mailService = new MailServiceImpl();
		otpService = new OtpServiceImpl();
		registrationService = new RegistrationServiceImpl();
		storeMcqOptionsDAO = new StoreMcqOptionsDAOImpl();
		storeQuestionDAO = new StoreQuestionDAOImpl();
		splitMcqAnswerService = new SplitMcqAnswerServiceImpl();
		storeMcqOptionService = new StoreMcqOptionServiceImpl();
		storeQuestionService = new StoreQuestionServiceImpl();
		addCourse = new AddCourseImpl();
		assignInstructor = new AssignInstructorImpl();
		deleteCourse = new DeleteCourseImpl();
		viewCourses = new ViewCoursesImpl();
		addCourseService = new AddCourseServiceImpl();
		assignInstructorService = new AssignInstructorServiceImpl();
		deleteCourseService = new DeleteCourseServiceImpl();
		viewCoursesService = new ViewCoursesServiceImpl();
		fetchQuestionService = new FetchQuestionServiceImpl();
		deleteQuestionService = new DeleteQuestionServiceImpl();
		fetchQuestionDAO = new FetchQuestionDAOImpl();
		deleteQuestionDAO = new DeleteQuestionDAOImpl();
		getQuestionsService = new GetQuestionsServiceImpl();
		getQuestionsDAO = new GetQuestionsDAOImpl();
	}

	public static SystemConfig instance() {

		if (null == uniqueInstance) {
			uniqueInstance = new SystemConfig();
		}

		return uniqueInstance;
	}

	public IDatabaseConfiguration getDatabaseConfiguration() {
		return databaseConfiguration;
	}

	public void setDatabaseConfiguration(IDatabaseConfiguration databaseConfiguration) {
		this.databaseConfiguration = databaseConfiguration;
	}

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public CourseAssociationDAO getCourseAssociationDAO() {
		return courseAssociationDAO;
	}

	public void setCourseAssociationDAO(CourseAssociationDAO courseAssociationDAO) {
		this.courseAssociationDAO = courseAssociationDAO;
	}

	public AssignTaService getAssignTaService() {
		return assignTaService;
	}

	public void setAssignTaService(AssignTaService assignTaService) {
		this.assignTaService = assignTaService;
	}

	public GetStudentListService getGetStudentListService() {
		return getStudentListService;
	}

	public void setGetStudentListService(GetStudentListService getStudentListService) {
		this.getStudentListService = getStudentListService;
	}

	public SendInvitationEmailService getSendInvitationEmailService() {
		return sendInvitationEmailService;
	}

	public void setSendInvitationEmailService(SendInvitationEmailService sendInvitationEmailService) {
		this.sendInvitationEmailService = sendInvitationEmailService;
	}

	public UploadCsvFileService getUploadCsvFileService() {
		return uploadCsvFileService;
	}

	public void setUploadCsvFileService(UploadCsvFileService uploadCsvFileService) {
		this.uploadCsvFileService = uploadCsvFileService;
	}

	public OtpDao getOtpDao() {
		return otpDao;
	}

	public void setOtpDao(OtpDao otpDao) {
		this.otpDao = otpDao;
	}

	public PasswordHistoryDao getPasswordHistoryDao() {
		return passwordHistoryDao;
	}

	public void setPasswordHistoryDao(PasswordHistoryDao passwordHistoryDao) {
		this.passwordHistoryDao = passwordHistoryDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public MailService getMailService() {
		return mailService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	public OtpService getOtpService() {
		return otpService;
	}

	public void setOtpService(OtpService otpService) {
		this.otpService = otpService;
	}

	public RegistrationService getRegistrationService() {
		return registrationService;
	}

	public void setRegistrationService(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}

	public StoreMcqOptionsDAO getStoreMcqOptionsDAO() {
		return storeMcqOptionsDAO;
	}

	public void setStoreMcqOptionsDAO(StoreMcqOptionsDAO storeMcqOptionsDAO) {
		this.storeMcqOptionsDAO = storeMcqOptionsDAO;
	}

	public StoreQuestionDAO getStoreQuestionDAO() {
		return storeQuestionDAO;
	}

	public void setStoreQuestionDAO(StoreQuestionDAO storeQuestionDAO) {
		this.storeQuestionDAO = storeQuestionDAO;
	}

	public SplitMcqAnswerService getSplitMcqAnswerService() {
		return splitMcqAnswerService;
	}

	public void setSplitMcqAnswerService(SplitMcqAnswerService splitMcqAnswerService) {
		this.splitMcqAnswerService = splitMcqAnswerService;
	}

	public StoreMcqOptionService getStoreMcqOptionService() {
		return storeMcqOptionService;
	}

	public void setStoreMcqOptionService(StoreMcqOptionService storeMcqOptionService) {
		this.storeMcqOptionService = storeMcqOptionService;
	}

	public StoreQuestionService getStoreQuestionService() {
		return storeQuestionService;
	}

	public void setStoreQuestionService(StoreQuestionService storeQuestionService) {
		this.storeQuestionService = storeQuestionService;
	}

	public AddCourse getAddCourse() {
		return addCourse;
	}

	public void setAddCourse(AddCourse addCourse) {
		this.addCourse = addCourse;
	}

	public AssignInstructor getAssignInstructor() {
		return assignInstructor;
	}

	public void setAssignInstructor(AssignInstructor assignInstructor) {
		this.assignInstructor = assignInstructor;
	}

	public DeleteCourse getDeleteCourse() {
		return deleteCourse;
	}

	public void setDeleteCourse(DeleteCourse deleteCourse) {
		this.deleteCourse = deleteCourse;
	}

	public ViewCourses getViewCourses() {
		return viewCourses;
	}

	public void setViewCourses(ViewCourses viewCourses) {
		this.viewCourses = viewCourses;
	}

	public AddCourseService getAddCourseService() {
		return addCourseService;
	}

	public void setAddCourseService(AddCourseService addCourseService) {
		this.addCourseService = addCourseService;
	}

	public AssignInstructorService getAssignInstructorService() {
		return assignInstructorService;
	}

	public void setAssignInstructorService(AssignInstructorService assignInstructorService) {
		this.assignInstructorService = assignInstructorService;
	}

	public DeleteCourseService getDeleteCourseService() {
		return deleteCourseService;
	}

	public void setDeleteCourseService(DeleteCourseService deleteCourseService) {
		this.deleteCourseService = deleteCourseService;
	}

	public ViewCoursesService getViewCoursesService() {
		return viewCoursesService;
	}

	public void setViewCoursesService(ViewCoursesService viewCoursesService) {
		this.viewCoursesService = viewCoursesService;
	}

	public FetchQuestionService getFetchQuestionService() {
		return fetchQuestionService;
	}

	public void setFetchQuestionService(FetchQuestionService fetchQuestionService) {
		this.fetchQuestionService = fetchQuestionService;
	}

	public DeleteQuestionService getDeleteQuestionService() {
		return deleteQuestionService;
	}

	public void setDeleteQuestionService(DeleteQuestionService deleteQuestionService) {
		this.deleteQuestionService = deleteQuestionService;
	}

	public FetchQuestionDAO getFetchQuestionDAO() {
		return fetchQuestionDAO;
	}

	public void setFetchQuestionDAO(FetchQuestionDAO fetchQuestionDAO) {
		this.fetchQuestionDAO = fetchQuestionDAO;
	}

	public DeleteQuestionDAO getDeleteQuestionDAO() {
		return deleteQuestionDAO;
	}

	public void setDeleteQuestionDAO(DeleteQuestionDAO deleteQuestionDAO) {
		this.deleteQuestionDAO = deleteQuestionDAO;
	}

	public void setQuestionService(GetQuestionsService getQuestionService) {
		this.getQuestionsService = getQuestionService;
	}

	public void setQuestionDAO(GetQuestionsDAO getQuestionDAO) {
		this.getQuestionsDAO = getQuestionDAO;
	}

	public GetQuestionsService getQuestionService() {
		return getQuestionsService;
	}

	public GetQuestionsDAO getQuestionDAO() {
		return getQuestionsDAO;
	}

}

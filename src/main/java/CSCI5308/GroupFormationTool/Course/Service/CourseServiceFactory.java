package CSCI5308.GroupFormationTool.Course.Service;

public class CourseServiceFactory extends CourseServiceAbstractFactory {

	private static CourseServiceFactory instance = null;
	private IAssignTaService assignTaService;
	private IGetStudentListService getStudentListService;
	private ISendInvitationEmailService sendInvitationEmailService;
	private IUploadCsvFileService uploadCsvFileService;
	private ICourseSurveyService courseSurveyService;

	private CourseServiceFactory() {
	}

	public static CourseServiceFactory instance() {
		if (null == instance) {
			instance = new CourseServiceFactory();
		}
		return instance;
	}

	@Override
	public IAssignTaService assignTaService() {
		if (null == assignTaService) {
			assignTaService = new AssignTaServiceImpl();
		}
		return assignTaService;
	}

	@Override
	public IGetStudentListService getStudentListService() {
		if (null == getStudentListService) {
			getStudentListService = new GetStudentListServiceImpl();
		}
		return getStudentListService;
	}

	@Override
	public ISendInvitationEmailService sendInvitationEmailService() {
		if (null == sendInvitationEmailService) {
			sendInvitationEmailService = new SendInvitationEmailServiceImpl();
		}
		return sendInvitationEmailService;
	}

	@Override
	public IUploadCsvFileService uploadCsvFileService() {
		if (null == uploadCsvFileService) {
			uploadCsvFileService = new UploadCsvFileServiceImpl();
		}
		return uploadCsvFileService;
	}

	@Override
	public ICourseSurveyService courseSurveyService() {
		if (null == courseSurveyService) {
			courseSurveyService = new CourseSurveyServiceImpl();
		}
		return courseSurveyService;
	}

}

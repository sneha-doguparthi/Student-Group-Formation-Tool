package CSCI5308.GroupFormationTool.Course.Service;

public abstract class CourseServiceAbstractFactory {
	public abstract IAssignTaService assignTaService();

	public abstract IGetStudentListService getStudentListService();

	public abstract ISendInvitationEmailService sendInvitationEmailService();

	public abstract IUploadCsvFileService uploadCsvFileService();

	public abstract ICourseSurveyService courseSurveyService();
}

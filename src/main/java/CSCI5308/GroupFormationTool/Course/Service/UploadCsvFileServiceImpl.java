package CSCI5308.GroupFormationTool.Course.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import CSCI5308.GroupFormationTool.Course.DAO.CourseDaoFactory;
import CSCI5308.GroupFormationTool.Course.DAO.ICourseAssociationDao;
import CSCI5308.GroupFormationTool.Model.Student;
import CSCI5308.GroupFormationTool.Profile.IUser;
import CSCI5308.GroupFormationTool.Profile.DAO.IUserDao;
import CSCI5308.GroupFormationTool.Profile.DAO.ProfileDaoFactory;
import CSCI5308.GroupFormationTool.Utilities.ApplicationConstants;

public class UploadCsvFileServiceImpl implements IUploadCsvFileService {

	private Logger logger = LogManager.getLogger(UploadCsvFileServiceImpl.class);
	private String resMessage;
	private Boolean resStatus;
	private List<Student> resStudentList;

	@Override
	public boolean uploadCsvFile(MultipartFile file, Integer courseId, String courseCode, String courseName) {
		IUserDao userDao = ProfileDaoFactory.instance().userDao();
		IGetStudentListService getStudentListService = CourseServiceFactory.instance().getStudentListService();
		ISendInvitationEmailService sendEmailService = CourseServiceFactory.instance().sendInvitationEmailService();
		ICourseAssociationDao courseAssociationDao = CourseDaoFactory.instance().courseAssociationDao();

		if (file.isEmpty()) {
			resMessage = ApplicationConstants.FILE_EMPTY;
			resStatus = ApplicationConstants.UPLOAD_STATUS_FALSE;
		} else {
			try {
				List<Student> students = parseCsv(file);

				ArrayList<Integer> userIdsFromCourseAssociation = courseAssociationDao.getUserID(courseId);
				ArrayList<IUser> userList = userDao.getUserByUserID(userIdsFromCourseAssociation);

				List<Student> newToCourseList = getStudentListService.getNewToCourseStudentList(students, userList);
				ArrayList<IUser> allUserList = userDao.getAll();

				List<Student> newToPortalList = getStudentListService.getNewToPortalStudentList(newToCourseList,
						allUserList);
				userDao.addUser(newToPortalList);

				ArrayList<Integer> userIdsFromUser = userDao.getUserID(newToCourseList);
				courseAssociationDao.addByUserID(userIdsFromUser, courseId);

				ArrayList<String> passwordFromUser = userDao.getPassword(newToPortalList);
				sendEmailService.sendUserInvitationEmail(newToPortalList, passwordFromUser);
				sendEmailService.sendCourseInvitationEmail(newToCourseList, courseCode, courseName);

				resMessage = ApplicationConstants.FILE_UPLOADED;
				resStatus = ApplicationConstants.UPLOAD_STATUS_TRUE;
				resStudentList = newToCourseList;
			} catch (Exception ex) {
				logger.error("Exception occurred while uploading CSV file", ex);
				resMessage = ApplicationConstants.FILE_ERROR;
				resStatus = ApplicationConstants.UPLOAD_STATUS_FALSE;
			}
		}

		return true;
	}

	@Override
	public List<Student> parseCsv(MultipartFile file) {
		List<Student> students = null;

		try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			CsvToBean<Student> csvToBean = new CsvToBeanBuilder<Student>(reader).withType(Student.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			students = csvToBean.parse();
		} catch (Exception ex) {
			logger.error("Exception occured while parsing CSV file: ", ex);
		}

		return students;
	}

	@Override
	public String getMessage() {
		return resMessage;
	}

	@Override
	public Boolean getStatus() {
		return resStatus;
	}

	@Override
	public List<Student> getStudentList() {
		return resStudentList;
	}
}

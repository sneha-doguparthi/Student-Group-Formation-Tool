package com.asdc.group6.CourseAdmin.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.asdc.group6.CourseAdmin.DAO.UserDAO;
import com.asdc.group6.CourseAdmin.DAO.CourseAssociationDAO;
import com.asdc.group6.Models.Student;
import com.asdc.group6.Models.User;
import com.asdc.group6.Utilities.ApplicationConstants;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Component
public class UploadCsvFileServiceImpl implements UploadCsvFileService {
	
	private String resMessage;
	private Boolean resStatus;
	private List<Student> resStudentList;
	
	private UserDAO userDao;
	private GetStudentListService getStudentListService;
	private SendInvitationEmailService sendEmailService;
	private CourseAssociationDAO courseAssociationDao;
	
	public UploadCsvFileServiceImpl(UserDAO userDao, GetStudentListService getStudentListService, 
									SendInvitationEmailService sendEmailService, CourseAssociationDAO courseAssociationDao) {
		this.userDao = userDao;
		this.getStudentListService = getStudentListService;
		this.sendEmailService = sendEmailService;
		this.courseAssociationDao = courseAssociationDao;
	}
	
	@Override
	public boolean uploadCsvFile(MultipartFile file, Integer courseId, String courseCode, String courseName) {
		
		if (file.isEmpty()) {
			resMessage = ApplicationConstants.FILE_EMPTY;
            resStatus = ApplicationConstants.UPLOAD_STATUS_FALSE;
		} else {
			try {     
	            List<Student> students = parseCsv(file);
	            System.out.println("CSV Student List Size-1: " + students.size());
	            
	            ArrayList<Integer> userIdsFromCourseAssociation = courseAssociationDao.getUserID(courseId);
	            System.out.println("User Id List from CourseAssociation: " + userIdsFromCourseAssociation.size());
	            ArrayList<User> userList = userDao.getUserByUserID(userIdsFromCourseAssociation);
	            System.out.println("User List from User: " + userList.size());
	            
	            List<Student> newToCourseList = getStudentListService.getNewToCourseStudentList(students, userList);
	    		System.out.println("CSV Student List Size-2: " + students.size());
	            System.out.println("New To Course List Size-1: " + newToCourseList.size());
	            
	            ArrayList<User> allUserList = userDao.getAll();
	    		System.out.println("All User List from User: " + allUserList.size());
	            List<Student> newToPortalList = getStudentListService.getNewToPortalStudentList(newToCourseList, allUserList);
	    		System.out.println("CSV Student List Size-3: " + students.size());
	            System.out.println("New To Course List Size-2: " + newToCourseList.size());
	            
	            userDao.addUser(newToPortalList);
	            
	            ArrayList<Integer> userIdsFromUser = userDao.getUserID(newToCourseList);
	            System.out.println("User Ids from User table for new to Course: " + userIdsFromUser.size());
	            courseAssociationDao.addByUserID(userIdsFromUser, courseId);
	            
	            ArrayList<String> passwordFromUser = userDao.getPassword(newToPortalList);
	            
	            sendEmailService.sendUserInvitationEmail(newToPortalList, passwordFromUser);
	            sendEmailService.sendCourseInvitationEmail(newToCourseList, courseCode, courseName);
	    		
	    		
	    		resMessage = ApplicationConstants.FILE_UPLOADED;
	            resStatus = ApplicationConstants.UPLOAD_STATUS_TRUE;
	            resStudentList = newToCourseList;
	            
			} catch (Exception ex) {
				ex.printStackTrace();
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

            CsvToBean<Student> csvToBean = new CsvToBeanBuilder<Student>(reader)
                    .withType(Student.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            
            students = csvToBean.parse();
	            
         } catch (Exception ex) {
			ex.printStackTrace();
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

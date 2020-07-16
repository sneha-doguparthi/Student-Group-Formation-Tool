package CSCI5308.GroupFormationTool.Utilities;

public class ApplicationConstants {

	// Mail configuration
	public static final String MAIL_HOST = "smtp.gmail.com";
	public static final int MAIL_PORT = 587;
	public static final String MAIL_SENDER_ID = "dalmcproject@gmail.com";
	public static final String MAIL_SENDER_PASSWORD = "ccsezaisrrtwpdzh";

	public static final String FILE_EMPTY = "Kindly select a CSV file to upload.";
	public static final String FILE_UPLOADED = "File uploaded successfully!";
	public static final String FILE_ERROR = "An error occured while processing the CSV file.";

	public static final Boolean UPLOAD_STATUS_TRUE = true;
	public static final Boolean UPLOAD_STATUS_FALSE = false;

	public static final String SQL_PARSE_ERROR = "An error occured while processing the CSV file. Could not update the database.";

	// DB Constants
	public static final String DB_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	// Add Course Error Codes
	public static final String COURSE_ADDED = "Course added successfully!";
	public static final String COURSE_ALREADY_EXISTS = "Course already exists!";
	public static final String COURSE_ADD_FAILED = "Failed to add course.";

	public static final String COURSE_ALREADY_ADDED_FOR_USER = "Course already added for User!";
	public static final String COURSE_ROLE_SUCCESS = "Instructor assigned successfully!";
	public static final String COURSE_ROLE_FAILED = "Failed to assign course!";
	public static final int GUEST_ROLE_ID = 1;
	public static final int STUDENT_ROLE_ID = 2;
	public static final int TA_ROLE_ID = 3;
	public static final int INSTRUCTOR_ROLE_ID = 4;
	public static final int ADMIN_ROLE_ID = 5;

	public static final String SELECT_COURSE_ERR = "Please select a course!";

	public static final String QUESTION_ANSWERS_ADDED = "Question and answers added successfully!";
	public static final String FAILED_QUESTION_ANSWERS_INSERTION = "Failed to add Question and answers!";

	public static final String FAILED_TO_SAVE_RESPONSE = "Failed to save survey response!";
	public static final String SURVEY_RESPONSE_SAVED = "Survey Response saved successfully!";
	public static final String DB_NOT_ACCESSIBLE = "Failed to connected to the database. Please try again after sometime.";

}

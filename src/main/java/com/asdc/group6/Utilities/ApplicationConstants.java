package com.asdc.group6.Utilities;

public class ApplicationConstants {

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
	public static final String COURSE_ROLE_SUCCESS = "Course assigned successfully!";
	public static final String COURSE_ROLE_FAILED = "Failed to assign course!";

}

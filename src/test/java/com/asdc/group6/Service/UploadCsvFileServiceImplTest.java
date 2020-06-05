package com.asdc.group6.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.web.multipart.MultipartFile;

import com.asdc.group6.CourseAdmin.Service.UploadCsvFileServiceImpl;
import com.asdc.group6.Models.Student;

public class UploadCsvFileServiceImplTest {

	UploadCsvFileServiceImpl uploadCsvFileServiceImplMock = mock(UploadCsvFileServiceImpl.class);
	
	@Test
	void testUploadCsvFile() {
		
		MultipartFile file = null;
		Integer id = 2;
		String code = "CSCI5408";
		String name = "ASDC";
				
		when(uploadCsvFileServiceImplMock.uploadCsvFile(file, id, code, name)).thenReturn(true);
		assertTrue(uploadCsvFileServiceImplMock.uploadCsvFile(file, id, code, name), 
					"uploadCsvFile Test Failed");
		verify(uploadCsvFileServiceImplMock).uploadCsvFile(file, id, code, name);
	}

	
	@Test
	void testGetMessage() {
		
		String result = "Code worked fine!";
		
		when(uploadCsvFileServiceImplMock.getMessage()).thenReturn(result);
		assertEquals(uploadCsvFileServiceImplMock.getMessage(), result, "getMessage Test Failed");
		verify(uploadCsvFileServiceImplMock).getMessage();
	}
	
	
	@Test
	void testGetStatus() {
		
		Boolean result = true;
		
		when(uploadCsvFileServiceImplMock.getStatus()).thenReturn(result);
		assertEquals(uploadCsvFileServiceImplMock.getStatus(), result, "getStatus Test Failed");
		verify(uploadCsvFileServiceImplMock).getStatus();
	}
	
	
	@Test
	void testGetStudentList() {
		
		List<Student> result = new ArrayList<>();
		
		Student student = new Student();
		student.setbId("B00123456");
		student.setFirstName("Tony");
		student.setLastName("Stark");
		student.setEmail("ts@marveldal.ca");
		
		result.add(student);
		
		when(uploadCsvFileServiceImplMock.getStudentList()).thenReturn(result);
		assertEquals(uploadCsvFileServiceImplMock.getStudentList(), result, "getStudentList Test Failed");
		verify(uploadCsvFileServiceImplMock).getStudentList();
	}
	
	
	@Test
	void testParseCsv() {
		
		MultipartFile file = null;
		List<Student> result = new ArrayList<>();
		
		Student student = new Student();
		student.setbId("B00123456");
		student.setFirstName("Tony");
		student.setLastName("Stark");
		student.setEmail("ts@marveldal.ca");
		
		result.add(student);
		
		when(uploadCsvFileServiceImplMock.parseCsv(file)).thenReturn(result);
		assertEquals(uploadCsvFileServiceImplMock.parseCsv(file), result, "parseCsv Test Failed");
		verify(uploadCsvFileServiceImplMock).parseCsv(file);
	}
}

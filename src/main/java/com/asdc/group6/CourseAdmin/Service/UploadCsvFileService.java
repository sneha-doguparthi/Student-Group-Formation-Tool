package com.asdc.group6.CourseAdmin.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.asdc.group6.Models.Student;

@Service
public interface UploadCsvFileService {

	public boolean uploadCsvFile(MultipartFile file, Integer courseId, String code, String name);
	public String getMessage();
	public Boolean getStatus();
	public List<Student> getStudentList();
	public List<Student> parseCsv(MultipartFile file);
	
}

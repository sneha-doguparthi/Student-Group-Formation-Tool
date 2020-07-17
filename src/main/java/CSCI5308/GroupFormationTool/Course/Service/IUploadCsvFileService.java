package CSCI5308.GroupFormationTool.Course.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import CSCI5308.GroupFormationTool.Model.Student;

public interface IUploadCsvFileService {

	public boolean uploadCsvFile(MultipartFile file, Integer courseId, String code, String name);

	public String getMessage();

	public Boolean getStatus();

	public List<Student> getStudentList();

	public List<Student> parseCsv(MultipartFile file);

}

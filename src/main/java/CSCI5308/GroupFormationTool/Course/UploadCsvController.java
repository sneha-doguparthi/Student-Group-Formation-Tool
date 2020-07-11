package CSCI5308.GroupFormationTool.Course;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import CSCI5308.GroupFormationTool.Course.Service.CourseServiceFactory;
import CSCI5308.GroupFormationTool.Course.Service.IUploadCsvFileService;
import CSCI5308.GroupFormationTool.Model.Student;

@Controller
public class UploadCsvController {

	IUploadCsvFileService uploadCsvFileService;

	public UploadCsvController() {
		this.uploadCsvFileService = CourseServiceFactory.instance().uploadCsvFileService();
	}

	@PostMapping("course-admin/upload-csv-home")
	public String uploadCSV(@RequestParam String courseId, @RequestParam String courseCode,
			@RequestParam String courseName, Model model) {

		model.addAttribute("courseId", courseId);
		model.addAttribute("courseName", courseName);
		model.addAttribute("courseCode", courseCode);

		return "course/upload-csv";
	}

	@PostMapping("course-admin/upload-csv")
	public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam String courseId,
			@RequestParam String courseCode, @RequestParam String courseName, Model model) {

		uploadCsvFileService.uploadCsvFile(file, Integer.valueOf(courseId), courseCode, courseName);
		String resMessage = uploadCsvFileService.getMessage();
		Boolean resStatus = uploadCsvFileService.getStatus();
		List<Student> resStudentList = uploadCsvFileService.getStudentList();
		model.addAttribute("message", resMessage);
		model.addAttribute("status", resStatus);
		if (resStatus) {
			model.addAttribute("students", resStudentList);
		}
		model.addAttribute("courseId", courseId);
		model.addAttribute("courseName", courseName);
		model.addAttribute("courseCode", courseCode);
		return "course/file-upload-status";
	}
}

package CSCI5308.GroupFormationTool.CourseAdmin;

import java.util.List;

import CSCI5308.GroupFormationTool.CourseAdmin.Service.UploadCsvFileServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import CSCI5308.GroupFormationTool.CourseAdmin.Service.UploadCsvFileService;
import CSCI5308.GroupFormationTool.Model.Student;

@Controller
public class UploadCsvController {

	@PostMapping("/upload-csv-home")
	public String uploadCSV(@RequestParam String id, @RequestParam String code, @RequestParam String name,
			Model model) {

		model.addAttribute("id", id);
		model.addAttribute("code", code);
		model.addAttribute("name", name);

		return "course/upload-csv";
	}

	@PostMapping("/upload-csv")
	public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam String id,
			@RequestParam String code, @RequestParam String name, Model model) {

		UploadCsvFileService uploadCsvFileService = new UploadCsvFileServiceImpl();

		uploadCsvFileService.uploadCsvFile(file, Integer.valueOf(id), code, name);
		String resMessage = uploadCsvFileService.getMessage();
		Boolean resStatus = uploadCsvFileService.getStatus();
		List<Student> resStudentList = uploadCsvFileService.getStudentList();
		model.addAttribute("message", resMessage);
		model.addAttribute("status", resStatus);
		if (resStatus) {
			model.addAttribute("students", resStudentList);
		}

		model.addAttribute("id", id);
		model.addAttribute("code", code);
		model.addAttribute("name", name);
		return "course/file-upload-status";
	}
}

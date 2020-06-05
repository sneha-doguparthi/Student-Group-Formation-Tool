package com.asdc.group6.CourseAdmin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.asdc.group6.CourseAdmin.Service.UploadCsvFileService;
import com.asdc.group6.Models.Student;

@Controller
public class UploadCsvController {

	private String resMessage;
	private Boolean resStatus;
	private List<Student> resStudentList;
	
	private UploadCsvFileService uploadCsvFileService;
	
	public UploadCsvController(UploadCsvFileService uploadCsvFileService) {
		this.uploadCsvFileService = uploadCsvFileService;
	}

	@PostMapping("/upload-csv-home")
	public String uploadCSV(@RequestParam String id, @RequestParam String code, 
			@RequestParam String name ,Model model) {
		
		model.addAttribute("id", id);
		model.addAttribute("code", code);
		model.addAttribute("name", name);

		return "upload-csv";
	}
	
	@PostMapping("/upload-csv")
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam String id, @RequestParam String code, 
			@RequestParam String name , Model model) {
 
		uploadCsvFileService.uploadCsvFile(file, Integer.valueOf(id), code, name);
		resMessage = uploadCsvFileService.getMessage();
		resStatus = uploadCsvFileService.getStatus();
		resStudentList = uploadCsvFileService.getStudentList(); 
		model.addAttribute("message", resMessage);
		model.addAttribute("status", resStatus);
		if(resStatus) {
			model.addAttribute("students", resStudentList);
		}
		
		model.addAttribute("id", id);
		model.addAttribute("code", code);
		model.addAttribute("name", name);
		return "file-upload-status";
	}
}		
	
//		if (file.isEmpty()) {
//            model.addAttribute("message", "Please select a CSV file to upload.");
//            model.addAttribute("status", false);
//    	} else {
		
		
		
//		if (file.isEmpty()) {
//            model.addAttribute("message", "Please select a CSV file to upload.");
//            model.addAttribute("status", false);
//    	} else {

            // parse CSV file to create a list of `User` objects
//            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
//
//                // create csv bean reader
//                CsvToBean<Student> csvToBean = new CsvToBeanBuilder<Student>(reader)
//                        .withType(Student.class)
//                        .withIgnoreLeadingWhiteSpace(true)
//                        .build();

                
                // convert `CsvToBean` object to list of users
//                List<Student> students = csvToBean.parse();
           
//                List<User> users = userRepository.findAll();
//                
//                User newStudent = new User();
	    	
//              JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//	    		mailSender.setHost("smtp.gmail.com"); mailSender.setPort(587);
//	    		mailSender.setUsername("dalmcproject@gmail.com");
//	    		mailSender.setPassword("ccsezaisrrtwpdzh");
//	    	
//	    		Properties props = mailSender.getJavaMailProperties();
//	    		props.put("mail.transport.protocol", "smtp");
//	    		props.put("mail.smtp.auth", "true");
//	    		props.put("mail.smtp.starttls.enable", "true");
//	    		props.put("mail.debug", "true");
//	    		  
//	    		SimpleMailMessage message = new SimpleMailMessage();
	    		
	    		
//                int students_size = students.size();
//                int users_size = users.size();
//                
//                for (int i=0; i<users_size; i++)
//                {
//                	for (int j=0; j<students_size; j++)
//                	{
//                		if (students.get(j).getbId().equals(users.get(i).getBannerId()))
//                		{
//                			User userToUpdate = users.get(i);
//                			userToUpdate.setUserType("S");
//                			userRepository.save(userToUpdate);
//                			
////                			message.setTo(users.get(i).getEmail());
////            	    		message.setSubject("Registration to a new course - CSCI5308");
////            	    		message.setText("Welcome" + users.get(i).getFirstName() + "to your new course CSCI5308 [Advance Software Development Concepts!]");
////            	    		mailSender.send(message);                            
//            	    		
//    	    				students.remove(j);
//                			students_size--;
//            	    		break;
//                		}
//                	}
//                }
                

//                // save users list on model
//                model.addAttribute("students", students);
//                model.addAttribute("message", "File uploaded successfully.");
//                model.addAttribute("status", true);
//                
//            } catch (Exception ex) {
//                model.addAttribute("message", "An error occurred while processing the CSV file.");
//                model.addAttribute("status", false);
//            }
//        }
//
//        return "FileUploadStatus";
//    }
//}

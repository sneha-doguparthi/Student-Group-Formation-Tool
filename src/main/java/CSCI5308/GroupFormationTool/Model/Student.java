package CSCI5308.GroupFormationTool.Model;

import com.opencsv.bean.CsvBindByName;

public class Student {

	@CsvBindByName(column = "Banner ID")
	private String bId;
	@CsvBindByName(column = "Last Name")
	private String lastName;
	@CsvBindByName(column = "First Name")
	private String firstName;
	@CsvBindByName(column = "Email")
	private String email;

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

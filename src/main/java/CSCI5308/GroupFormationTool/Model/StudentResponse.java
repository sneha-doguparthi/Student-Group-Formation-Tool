package CSCI5308.GroupFormationTool.Model;

import java.util.ArrayList;
import java.util.List;

public class StudentResponse {

	private int userId;
	private List<String> responseValue = new ArrayList<>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<String> getResponseValue() {
		return responseValue;
	}

	public void setResponseValue(List<String> responseValue) {
		this.responseValue = responseValue;
	}
}

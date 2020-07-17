package CSCI5308.GroupFormationTool.Profile;

public class User implements IUser {

	private int userId;
	private String firstName;
	private String lastName;
	private String bannerId;
	private String email;
	private String password;
	private String confirmPassword;
	private String userType;

	@Override
	public int getUserId() {
		return userId;
	}

	@Override
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String getBannerId() {
		return bannerId;
	}

	@Override
	public void setBannerId(String bannerId) {
		this.bannerId = bannerId;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getConfirmPassword() {
		return confirmPassword;
	}

	@Override
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String getUserType() {
		return userType;
	}

	@Override
	public void setUserType(String userType) {
		this.userType = userType;
	}
}

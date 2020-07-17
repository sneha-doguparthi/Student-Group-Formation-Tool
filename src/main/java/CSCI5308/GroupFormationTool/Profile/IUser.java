package CSCI5308.GroupFormationTool.Profile;

public interface IUser {
	public int getUserId();

	public void setUserId(int userId);

	public String getFirstName();

	public void setFirstName(String firstName);

	public String getLastName();

	public void setLastName(String lastName);

	public String getBannerId();

	public void setBannerId(String bannerId);

	public String getEmail();

	public void setEmail(String email);

	public String getPassword();

	public void setPassword(String password);

	public String getConfirmPassword();

	public void setConfirmPassword(String confirmPassword);

	public String getUserType();

	public void setUserType(String userType);
}

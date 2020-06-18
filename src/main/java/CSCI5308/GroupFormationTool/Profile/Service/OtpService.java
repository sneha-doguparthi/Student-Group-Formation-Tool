package CSCI5308.GroupFormationTool.Profile.Service;

public interface OtpService {

	String sendOtp(String email);
	String verifyOtp(String email, String otp, String password);

}

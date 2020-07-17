package CSCI5308.GroupFormationTool.Profile.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class OtpServiceImplTest {

	IOtpService otpServiceImplMock = mock(OtpServiceImpl.class);

	@Test
	void testSendOtp() {

		when(otpServiceImplMock.sendOtp("test@gmail.com")).thenReturn("success");
		assertEquals(otpServiceImplMock.sendOtp("test@gmail.com"), "success", "Otp not sent");
		verify(otpServiceImplMock).sendOtp("test@gmail.com");

	}

	@Test
	void testVerifyOtp() {

		when(otpServiceImplMock.verifyOtp("test@gmail.com", "1234", "testpassword")).thenReturn("password_updated");
		assertEquals(otpServiceImplMock.verifyOtp("test@gmail.com", "1234", "testpassword"), "password_updated",
				"otp_invalid");
		verify(otpServiceImplMock).verifyOtp("test@gmail.com", "1234", "testpassword");

	}
}

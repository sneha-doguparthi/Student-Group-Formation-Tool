package CSCI5308.GroupFormationTool.Profile.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Model.Otp;

public class OtpDaoImplTest {

	OtpDao otpDaoImplMock = mock(OtpDaoImpl.class);

	@Test
	void testInsertOtp() {

		Otp otp = new Otp();
		otp.setEmail("test@gmail.com");
		otp.setOtp(1234);
		otp.setDate(new Date());

		when(otpDaoImplMock.insertOtp(otp)).thenReturn(true);
		assertTrue(otpDaoImplMock.insertOtp(otp), "Error while inserting otp into database");
		verify(otpDaoImplMock).insertOtp(otp);
	}

	@Test
	void testGetOtpByEmail() {

		ArrayList<Otp> list = new ArrayList<>();

		Otp otp = new Otp();
		otp.setEmail("test@gmail.com");
		otp.setOtp(1234);
		otp.setDate(new Date());

		list.add(otp);

		when(otpDaoImplMock.getOtpByEmail("test@gmail.com")).thenReturn(list);
		assertEquals(otpDaoImplMock.getOtpByEmail("test@gmail.com"), list, "No data present in database");
		verify(otpDaoImplMock).getOtpByEmail("test@gmail.com");
	}
}

package CSCI5308.GroupFormationTool.Profile.Service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

public class MailServiceImplTest {

	MailService mailServiceImplMock = mock(MailServiceImpl.class);

	@Test
	void testSendMail() {

		String email = "test@gmail.com";
		String subject = "Test Subject";
		String text = "Test Text";

		when(mailServiceImplMock.sendMail(email, subject, text)).thenReturn(true);
		assertTrue(mailServiceImplMock.sendMail(email, subject, text), "Mail not sent");
		verify(mailServiceImplMock).sendMail(email, subject, text);
	}
}

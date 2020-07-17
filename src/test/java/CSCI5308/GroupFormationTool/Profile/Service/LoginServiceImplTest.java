package CSCI5308.GroupFormationTool.Profile.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

public class LoginServiceImplTest {

	ILoginService loginServiceImplMock = mock(LoginServiceImpl.class);

	@Test
	void testCheckAccessService() {

		Model model = new ExtendedModelMap();

		when(loginServiceImplMock.checkAccessService("xyz@gmail.com", model)).thenReturn("login");
		assertEquals(loginServiceImplMock.checkAccessService("xyz@gmail.com", model), "login", "error");
		verify(loginServiceImplMock).checkAccessService("xyz@gmail.com", model);
	}
}

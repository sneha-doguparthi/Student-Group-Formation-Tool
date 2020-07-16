package CSCI5308.GroupFormationTool.Survey.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Profile.IUser;
import CSCI5308.GroupFormationTool.Profile.UserFactory;
import CSCI5308.GroupFormationTool.Profile.UserObjectFactory;

public class DesignGroupServiceImplTest {
	IDesignGroupService designGroupServiceMock = mock(DesignGroupServiceImpl.class);

	@Test
	void designGroupTest() {
		Map<String, ArrayList<IUser>> groupInformation = new HashMap<>();
		ArrayList<IUser> users = new ArrayList<>();

		IUser user = UserFactory.userObject(new UserObjectFactory());
		user.setBannerId("B12345678");
		user.setFirstName("First");
		user.setLastName("Last");
		user.setUserId(1);
		user.setPassword("password");

		users.add(user);

		groupInformation.put("groupedUser", users);

		when(designGroupServiceMock.designGroup(12)).thenReturn(groupInformation);
		assertEquals(designGroupServiceMock.designGroup(12), groupInformation, "Error");
		verify(designGroupServiceMock).designGroup(12);
	}
}

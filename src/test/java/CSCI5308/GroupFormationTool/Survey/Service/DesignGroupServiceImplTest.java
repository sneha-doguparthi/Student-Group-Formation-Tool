package CSCI5308.GroupFormationTool.Survey.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class DesignGroupServiceImplTest {
	IDesignGroupService designGroupServiceMock = mock(DesignGroupServiceImpl.class);

	@Test
	void designGroupTest() {
		Map<String, ArrayList<String>> groupInformation = new HashMap<>();
		ArrayList<String> users = new ArrayList<>();

		users.add("B00123456| First | Last");
		users.add("B00123456| Hello | World");
		users.add("B00123456| No | Name");

		groupInformation.put("groupedUser", users);

		when(designGroupServiceMock.designGroup(12)).thenReturn(groupInformation);
		assertEquals(designGroupServiceMock.designGroup(12), groupInformation, "Error");
		verify(designGroupServiceMock).designGroup(12);
	}
}

package CSCI5308.GroupFormationTool.Survey.Service;

import CSCI5308.GroupFormationTool.Model.StudentResponse;
import CSCI5308.GroupFormationTool.Profile.IUser;
import CSCI5308.GroupFormationTool.Profile.UserFactory;
import CSCI5308.GroupFormationTool.Profile.UserObjectFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DesignGroupServiceImplTest {
    IDesignGroupService designGroupServiceMock = mock(DesignGroupServiceImpl.class);

    @Test
    void designGroupTest(){
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

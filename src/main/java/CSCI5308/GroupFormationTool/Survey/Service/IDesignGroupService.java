package CSCI5308.GroupFormationTool.Survey.Service;

import CSCI5308.GroupFormationTool.Profile.IUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IDesignGroupService {
    Map<String, ArrayList<IUser>> designGroup(int courseId);
}

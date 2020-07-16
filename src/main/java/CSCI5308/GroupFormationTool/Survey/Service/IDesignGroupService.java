package CSCI5308.GroupFormationTool.Survey.Service;

import java.util.ArrayList;
import java.util.Map;

import CSCI5308.GroupFormationTool.Profile.IUser;

public interface IDesignGroupService {
	Map<String, ArrayList<IUser>> designGroup(int courseId);
}

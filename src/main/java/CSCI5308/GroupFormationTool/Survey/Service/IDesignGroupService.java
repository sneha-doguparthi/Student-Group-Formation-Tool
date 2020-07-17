package CSCI5308.GroupFormationTool.Survey.Service;

import java.util.ArrayList;
import java.util.Map;

public interface IDesignGroupService {
	Map<String, ArrayList<String>> designGroup(int courseId);
}

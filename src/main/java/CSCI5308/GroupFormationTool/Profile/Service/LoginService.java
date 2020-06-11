package CSCI5308.GroupFormationTool.Profile.Service;

import org.springframework.ui.Model;
import CSCI5308.GroupFormationTool.Model.User;

public interface LoginService {
	public String checkAccessService(User user, Model model);
}

package CSCI5308.GroupFormationTool.Profile.Service;

import org.springframework.ui.Model;

public interface LoginService {

	public String checkAccessService(String email, Model model);

}

package CSCI5308.GroupFormationTool.Profile.Service;

import org.springframework.ui.Model;

public interface ILoginService {

	public String checkAccessService(String email, Model model);

}

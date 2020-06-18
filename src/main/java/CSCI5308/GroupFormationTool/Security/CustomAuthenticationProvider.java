package CSCI5308.GroupFormationTool.Security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.Profile.DAO.UserDao;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String email = authentication.getName();
		String password = authentication.getCredentials().toString();
		UserDao userDao = SystemConfig.instance().getUserDao();
		ArrayList<User> allUsers = userDao.getByEmail(email);

		if (allUsers.size() != 0) {
			User validUser = allUsers.get(0);
			if (validUser.getPassword().equals(password)) {
				List<GrantedAuthority> authority = new ArrayList<>();
				if (validUser.getUserType().equals("A")) {
					authority.add(new SimpleGrantedAuthority("ADMIN"));
				}
				return new UsernamePasswordAuthenticationToken(email, password, authority);
			} else {
				throw new BadCredentialsException("1001");
			}
		} else {
			throw new BadCredentialsException("1001");
		}

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
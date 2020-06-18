package CSCI5308.GroupFormationTool.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.headers().disable().authorizeRequests().antMatchers("/profile/**").permitAll().antMatchers("/course.css")
				.permitAll().antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest().authenticated().and()
				.formLogin().loginPage("/profile/login").successForwardUrl("/").permitAll().and().logout().permitAll();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(new CustomAuthenticationProvider());
	}
}

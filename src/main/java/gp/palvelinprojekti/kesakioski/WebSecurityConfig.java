package gp.palvelinprojekti.kesakioski;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import gp.palvelinprojekti.kesakioski.web.UserDetailServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
@Override
protected void configure(HttpSecurity http) throws Exception{
	http
	.authorizeRequests().antMatchers("/css/**", "/tuotelista","/h2-console/**","/signup","/saveuser").permitAll()
	.and()
	.authorizeRequests().antMatchers("/poista/{id}","/muokkaa/{id}","/palautelista","/tyhjenna/{id}").hasAuthority("ADMIN")
	.and()
	.authorizeRequests().antMatchers("/palaute").hasAuthority("USER")
	.and()
	.authorizeRequests().anyRequest().authenticated()
	.and()
	.csrf().ignoringAntMatchers("/h2-console/**")
	 .and()
	 .headers().frameOptions().sameOrigin()
	.and()
	.formLogin()
	.loginPage("/kirjaudu")
	.defaultSuccessUrl("/tuotelista")
	.permitAll()
	.and()
	.logout()
	.permitAll();
}
@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
	auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
}
}

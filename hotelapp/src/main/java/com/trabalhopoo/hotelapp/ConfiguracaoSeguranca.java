/*
package com.trabalhopoo.hotelapp;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

//import br.edu.ifpr.paranavai.poswebsys.adm.dominio.Role;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter {

	private static final String USER = null;

	//@Autowired
	//private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			//.antMatchers("/css/**", "/js/**", "/resources/**", "/error").permitAll()
			//.antMatchers("/adm/**").hasAuthority(Role.ADMIN.getNome())
			.anyRequest().authenticated()
			.and()
		.formLogin()
			//.loginPage("/login")
			//.defaultSuccessUrl("/home")
			.permitAll()
			.and()
		.logout()
			.permitAll();
	}
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("thiago")
				.password("thiago")
				.roles(USER)
				.build();
		return new InMemoryUserDetailsManager(user);
	}
	
	//@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}
	
}
*/
package com.hostal.springboot.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hostal.springboot.app.commons.LoginSuccesHandler;
import com.hostal.springboot.app.services.UsuarioServiceImp;

@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
@Configuration
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private LoginSuccesHandler successHandler;
	
	@Autowired
	private UsuarioServiceImp userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	//Autorizaciones http
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/img/**","/catalogo","/home").permitAll()
		/*.antMatchers("/reserva/**").hasAnyRole("USER")
		.antMatchers("/save/**").hasAnyRole("USER")
		.antMatchers("/formulario-huesped/**").hasAnyRole("ADMIN") */
		.anyRequest().authenticated()
		.and()
		    .formLogin()
		        .successHandler(successHandler)
//		        .loginPage("/login")
		    .permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error_403");
	}
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception
	{
		build.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);

	}

	
	
}

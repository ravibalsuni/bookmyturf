package com.bookmyturf.config;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.bookmyturf.filter.JwtFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
	private Logger log = LoggerFactory.getLogger(SecurityConfig.class);
	
	public SecurityConfig() {
		log.info("SecurityConfig() invoked!!");
	}
	
	@Autowired
	public JwtFilter jwtfilter;
	
	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception{
		log.info("authenticationManagerBean - "+configuration.getAuthenticationManager().toString());
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		log.info("passwordEncoder() invoked!");
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		//enable cors and disable scrf
		log.info("securityFilterChain() invoked!!");
		http = http.cors().and().csrf().disable();
		// set session mgmt to stateless
		http = http
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and();
		// set unathorized requests exception handler
		http = http
				.exceptionHandling()
				.authenticationEntryPoint(
						(request,response,ex) ->{
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
				})
				.and();
		//set permission to endpoint
		http.authorizeRequests()
		//public endpoints
		.antMatchers("/camunda*").hasAuthority("camunda-admin")
		.antMatchers("/login/authenticate").permitAll()
		.antMatchers("/swagger*").permitAll()
		
		//private endpoints
		.antMatchers("/login/welcome").authenticated()
		.antMatchers("/test/**").authenticated();
		log.info("add filter before call after this..");
		http.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);
		DefaultSecurityFilterChain chain = http.build();
		return chain;
	}
}

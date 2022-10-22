package com.bookmyturf.service;

import java.util.Collection;
import java.util.Collections;

import org.camunda.bpm.engine.IdentityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class JwtAuthenticationService implements AuthenticationProvider {

	private Logger log = LoggerFactory.getLogger(JwtAuthenticationService.class);
	
	@Autowired
	private IdentityService identityService;
	
	public JwtAuthenticationService() {
		log.info("JwtAuthenticationService() invoked!!");
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		log.info("JwtAuthenticationService -- authenticate() invoked!");
		String userName=authentication.getName();
		log.info("username -"+userName);
		String password=null;
		if(authentication.getCredentials()!=null)
			password=authentication.getCredentials().toString();
		log.info("pwd -"+password);
		boolean result = identityService.checkPassword(userName, password);
		if(result) {
			Collection<? extends GrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
			log.info("result - "+result);
			return new UsernamePasswordAuthenticationToken(userName, password,authorities);
		}
		else {
			log.info("result - "+result);
			throw new BadCredentialsException("User Authentication Failed");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		log.info("JwtAuthenticationService - supports() invoked!");
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}

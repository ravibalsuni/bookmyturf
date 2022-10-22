package com.bookmyturf.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.bookmyturf.service.JwtService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtFilter extends OncePerRequestFilter{
	
	private Logger log = LoggerFactory.getLogger(JwtFilter.class);
	
	public JwtFilter() {
		log.info("JwtFilter() invoked!!");
	}
	@Autowired
	private JwtService jwtservice;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)throws ServletException, IOException {
		String authorizationHeader=request.getHeader(HttpHeaders.AUTHORIZATION);
		String token=null;
		String userName=null;
		
		if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")) {
			try {
				token=authorizationHeader.split(" ")[1].trim();
				userName=jwtservice.extractUsername(token);
			}
			catch (Exception e) {
				log.info("unable to authenticate user, bad request");
			}
		}
		 if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

	            UserDetails userDetails = new User(userName, "dummy-pwd", new ArrayList<>());

	            if (jwtservice.validateToken(token, userDetails)) {

	                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
	                        new UsernamePasswordAuthenticationToken(userDetails, "hardcoded-pwd", userDetails.getAuthorities());
	                usernamePasswordAuthenticationToken
	                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	            }
	        }
		filterChain.doFilter(request, response);
	}

}

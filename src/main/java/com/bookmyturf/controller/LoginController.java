package com.bookmyturf.controller;

import java.io.Serializable;
import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyturf.entity.JwtResponse;
import com.bookmyturf.entity.LoginRequest;
import com.bookmyturf.service.JwtService;

import io.swagger.annotations.ApiImplicitParam;

@RestController
@RequestMapping(path="/login")
public class LoginController {

	private Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;
	
	@CrossOrigin("*")
	@GetMapping("/welcome")
	@ApiImplicitParam(name = "Authorization", value = "Enter Token", required = true , allowEmptyValue = true, paramType = "header", dataTypeClass = String.class, example = "Bearer replace_this_with_your_token" )
	public String welcome() {
		return "welcome to the page";
	}
	
	@CrossOrigin("*")
	@PostMapping("/authenticate")
	@ApiImplicitParam(name = "role", value = "Enter role", required = true , allowEmptyValue = true, paramType = "header", dataTypeClass = String.class )
	public ResponseEntity<Serializable> login(@RequestBody(required = true)LoginRequest loginRequest){
		log.info("/authenticate api invoked!");
		try {
			Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));	
			String token = jwtService.generateToken(authentication.getName());
			log.info("token - "+token);
			return ResponseEntity.ok(new JwtResponse(token));
		}catch (Exception e) {
			return ResponseEntity.badRequest().body("Failed to login");
		}
	}	
	
	@CrossOrigin("*")
	@GetMapping("/getloggedinuser")
	@ApiImplicitParam(name = "role", value = "Enter role", required = true , allowEmptyValue = true, paramType = "header", dataTypeClass = String.class )
	public String getloggedinuser(Principal principal){
		System.out.println(principal.toString());
		return principal.getName();
	}	
}

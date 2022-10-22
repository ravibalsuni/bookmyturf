package com.bookmyturf.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;

@RestController
public class ABasicController {

	@GetMapping("/test/get")
	@CrossOrigin("*")
	@ApiImplicitParam(name = "Authorization", value = "Enter Token", required = false , allowEmptyValue = true, paramType = "header", dataTypeClass = String.class, example = "Bearer replace_this_with_your_token" )
	public String testGet() {
		return "Get Mapping Works Fine";
	}
	
	@PostMapping("/test/post")
	@CrossOrigin("*")
	public String testPost() {
		return "Post Mapping Works Fine";
	}
}

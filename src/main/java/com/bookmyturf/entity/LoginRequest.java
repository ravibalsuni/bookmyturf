package com.bookmyturf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	@Override
	public String toString() {
		return "LoginRequest [username=" + username + ", password=" + password + "]";
	}
}

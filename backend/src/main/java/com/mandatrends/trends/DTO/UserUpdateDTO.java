package com.mandatrends.trends.DTO;

import com.mandatrends.trends.services.validation.UserUpdateValid;

@UserUpdateValid
public class UserUpdateDTO extends UserDTO {
	private static final long serialVersionUID = 1L;
	
private String password;
	
	public UserUpdateDTO () {
	}

	public UserUpdateDTO(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}

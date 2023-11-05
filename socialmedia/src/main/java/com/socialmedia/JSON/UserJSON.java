package com.socialmedia.JSON;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.socialmedia.model.LoginModel;
import com.socialmedia.model.UserDetailsModel;

@JsonIgnoreProperties
public class UserJSON {
	private LoginModel user;
	private UserDetailsModel userdetails;
	public LoginModel getUser() {
		return user;
	}
	public UserDetailsModel getUserdetails() {
		return userdetails;
	}
	public void setUser(LoginModel user) {
		this.user = user;
	}
	public void setUserdetails(UserDetailsModel userdetails) {
		this.userdetails = userdetails;
	}
	
	
	
}	

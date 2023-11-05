package com.socialmedia.JSON;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LikeResponseJSON {
	
	@JsonProperty
	private UserJSON user;

	public UserJSON getUser() {
		return user;
	}

	public void setUser(UserJSON user) {
		this.user = user;
	}
	

}

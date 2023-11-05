package com.socialmedia.JSON;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.socialmedia.utils.TrueFalse;

public class LikeCommentJSON {

	@JsonProperty(value ="post_id",required = false)
	private String postId;
	@JsonProperty(value ="user_id",required = false)
	private String userId;
	@JsonProperty(value ="is_like",required = false)
	private boolean isLike;
	@JsonProperty(value ="value",required = false)
	private String value;
	public String getPostId() {
		return postId;
	}
	public String getUserId() {
		return userId;
	}
	
	public String getValue() {
		return value;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isLike() {
		return isLike;
	}
	public void setLike(boolean isLike) {
		this.isLike = isLike;
	}
	
}

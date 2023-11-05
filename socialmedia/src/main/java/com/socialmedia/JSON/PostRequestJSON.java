package com.socialmedia.JSON;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRequestJSON {
	@JsonProperty(value ="post_id",required = false)
	private String postId;
	@JsonProperty(value ="userid" ,required = false)
	private String UserId;
	@JsonProperty(value ="post_orginalname" ,required = false)
	private String postOrginalName;
	@JsonProperty(value ="post_type" ,required = false)
	private String postType;
	@JsonProperty(value ="post_img" ,required = false)
	private String postImg;
	@JsonProperty(value ="post_caption" ,required = false)
	private String postCaption;
	public String getPostId() {
		return postId;
	}
	public String getUserId() {
		return UserId;
	}
	public String getPostOrginalName() {
		return postOrginalName;
	}
	public String getPostType() {
		return postType;
	}
	public String getPostImg() {
		return postImg;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public void setPostOrginalName(String postOrginalName) {
		this.postOrginalName = postOrginalName;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	public void setPostImg(String postImg) {
		this.postImg = postImg;
	}
	public String getPostCaption() {
		return postCaption;
	}
	public void setPostCaption(String postCaption) {
		this.postCaption = postCaption;
	}
	
}

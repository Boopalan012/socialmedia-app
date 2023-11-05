package com.socialmedia.JSON;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.socialmedia.model.LoginModel;
import com.socialmedia.model.UserDetailsModel;

import lombok.Data;

@Data
public class PostJSON {
	
	@JsonProperty(value ="post_id",required = false)
	private String postId;
	@JsonProperty(value="name",required = false)
	private String name;
	@JsonProperty(value ="userid" ,required = false)
	private String UserId;
	@JsonProperty(value ="post_path" ,required = false)
	private String postPath;
	@JsonProperty(value ="post_orginalname" ,required = false)
	private String postOrginalName;
	@JsonProperty(value ="post_type" ,required = false)
	private String postType;
	@JsonProperty(value ="post_img" ,required = false)
	private String postImg;
	@JsonProperty(value ="like" ,required = false)
	private List<LikeResponseJSON> like;
	@JsonProperty(value ="likecount" ,required = false)
	private long likeCount;
	@JsonProperty(value ="comment" ,required = false)
	private List<CommentResponseJSON> comment;
	@JsonProperty(value ="post_user" ,required = false)
	private LoginModel postUser;
	@JsonProperty(value ="post_userdetails" ,required = false)
	private UserDetailsModel postUserDetails;
	
	
	
	public LoginModel getPostUser() {
		return postUser;
	}
	public UserDetailsModel getPostUserDetails() {
		return postUserDetails;
	}
	public void setPostUser(LoginModel postUser) {
		this.postUser = postUser;
	}
	public void setPostUserDetails(UserDetailsModel postUserDetails) {
		this.postUserDetails = postUserDetails;
	}
	public String getPostId() {
		return postId;
	}
	public String getName() {
		return name;
	}
	public String getUserId() {
		return UserId;
	}
	public void setPostId(String string) {
		this.postId = string;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getPostPath() {
		return postPath;
	}
	public void setPostPath(String postPath) {
		this.postPath = postPath;
	}
	public String getPostOrginalName() {
		return postOrginalName;
	}
	public String getPostType() {
		return postType;
	}
	public void setPostOrginalName(String postOrginalName) {
		this.postOrginalName = postOrginalName;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	public String getPostImg() {
		return postImg;
	}
	public void setPostImg(String postImg) {
		this.postImg = postImg;
	}
	public List<LikeResponseJSON> getLike() {
		return like;
	}
	public List<CommentResponseJSON> getComment() {
		return comment;
	}
	public void setLike(List<LikeResponseJSON> like) {
		this.like = like;
	}
	public void setComment(List<CommentResponseJSON> comment) {
		this.comment = comment;
	}
	public long getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(long likeCount) {
		this.likeCount = likeCount;
	}

	
	

	
	
	

}

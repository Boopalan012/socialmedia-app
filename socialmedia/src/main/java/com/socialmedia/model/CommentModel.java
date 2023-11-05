package com.socialmedia.model;

import java.util.Date;

import com.socialmedia.utils.AppUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sm_comment")
public class CommentModel {
	@Id
	private String id;
	@Column
	private String userId;
	@Column
	private String postId;
	@Column
	private String comment;
	@Column(name="created_at")
	private String createdAt;
	@Column(name ="updated_at")
	private String updatedAt;
	
	public CommentModel() {
		createdAt=AppUtils.formatDate(new Date());
		updatedAt=AppUtils.formatDate(new Date());	}
	public String getId() {
		return id;
	}
	public String getUserId() {
		return userId;
	}
	public String getPostId() {
		return postId;
	}
	public String getComment() {
		return comment;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}

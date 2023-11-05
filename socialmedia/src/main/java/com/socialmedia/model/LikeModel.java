package com.socialmedia.model;

import java.util.Date;

import com.socialmedia.utils.AppUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sm_like")
public class LikeModel {

	@Id
	private String id;
	@Column
	private String userId;
	@Column
	private String postId;
	@Column(name="created_at")
	private String cretedAt;
	@Column(name ="updated_at")
	private String updatedAt;
	public String getId() {
		return id;
	}
	public String getUserId() {
		return userId;
	}
	public String getPostId() {
		return postId;
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
	public String getCretedAt() {
		return cretedAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setCretedAt(String cretedAt) {
		this.cretedAt = cretedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public LikeModel() {
		cretedAt=AppUtils.formatDate(new Date());
		updatedAt=AppUtils.formatDate(new Date());	}
	
}

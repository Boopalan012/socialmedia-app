package com.socialmedia.model;

import java.util.Date;

import com.socialmedia.utils.AppUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sm_follower")
public class FollowerModel {

    @Id
	private String id;
    @Column(name = "user_id")
	private String UserId;
    @Column(name = "follower_id")
	private String followerId;
    @Column(name="created_at")
	private String cretedAt;
	@Column(name ="updated_at")
	private String updatedAt;
	public String getId() {
		return id;
	}
	public String getUserId() {
		return UserId;
	}
	public String getFollowerId() {
		return followerId;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public void setFollowerId(String followerId) {
		this.followerId = followerId;
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
	public FollowerModel() {
		cretedAt=AppUtils.formatDate(new Date());
		updatedAt=AppUtils.formatDate(new Date());	}
    
}

package com.socialmedia.model;

import java.util.Date;

import com.socialmedia.utils.AppUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "sm_post")
public class PostModel {
	@Id
	@Column(name="post_id")
	private String PostId;
	@Column(name = "user_id")
	private String userId;
	@Column(name="post_name")
	private String PostName;
	@Column(name="post_caption")
	private String postCaption;
	@Column(name="post_content_type")
	private String contentType;
	@Column(name="post_size")
	private long postSize;
	@Column(name = "post_pic", nullable = true ,columnDefinition = "BLOB")
    @Lob
    private String postPic;
	public String getPostPic() {
		return postPic;
	}
	public void setPostPic(String postPic) {
		this.postPic = postPic;
	}
	@Column(name="created_at")
	private String createdAt;
	@Column(name ="updated_at")
	private String updatedAt;
	public PostModel() {
		createdAt=AppUtils.formatDate(new Date());
		updatedAt=AppUtils.formatDate(new Date());
	}
	public String getPostId() {
		return PostId;
	}
	public String getUserId() {
		return userId;
	}
	public String getPostName() {
		return PostName;
	}
	public String getPostCaption() {
		return postCaption;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setPostId(String postId) {
		PostId = postId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setPostName(String postName) {
		PostName = postName;
	}
	public void setPostCaption(String postCaption) {
		this.postCaption = postCaption;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getContentType() {
		return contentType;
	}
	public long getPostSize() {
		return postSize;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public void setPostSize(long l) {
		this.postSize = l;
	}
	
	}

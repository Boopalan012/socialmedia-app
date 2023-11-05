package com.socialmedia.model;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.socialmedia.utils.AppUtils;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sm_login")
public class LoginModel {

	@Id
	@Nullable
	private String id;
	@Column(name = "username")
	@Nullable
	private String username;
	@Column(name="email")
	@Nullable
	private String email;
	@Column(name = "password")
	@Nullable
	private String password;
	@Column(name = "is_active")
	@Nullable
	private boolean isActive;
	@Column(name ="userdetails_required")
	@Nullable
	private boolean userDetailsRequired;
	@Column(name="created_at")
	private String cretedAt;
	@Column(name ="updated_at")
	private String updatedAt;
	
	public LoginModel() {
		cretedAt=AppUtils.formatDate(new Date());
		updatedAt=AppUtils.formatDate(new Date());
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setId(String string) {
		this.id = string;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password =password;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isUserDetailsRequired() {
		return userDetailsRequired;
	}

	public void setUserDetailsRequired(boolean userDetailsRequired) {
		this.userDetailsRequired = userDetailsRequired;
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
	

}

package com.socialmedia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.socialmedia.model.UserDetailsModel;

public interface UserDetailsDao extends JpaRepository<UserDetailsModel, String> {
	
	@Query(value = "select * from user_details where user_id=?1",nativeQuery = true)
	UserDetailsModel findByuserId(String id);

}

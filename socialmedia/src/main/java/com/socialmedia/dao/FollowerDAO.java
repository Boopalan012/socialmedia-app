package com.socialmedia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.socialmedia.model.FollowerModel;

public interface FollowerDAO extends JpaRepository<FollowerModel,String> {

	@Query(value = "select * from sm_follower as fl where fl.user_id=?1 ",nativeQuery = true)
	List<FollowerModel> getByuserId(String id);
	@Query(value = "select * from sm_follower as fl where fl.follower_id=?1 ",nativeQuery = true)
	List<FollowerModel> getByFollowerId(String id);

}

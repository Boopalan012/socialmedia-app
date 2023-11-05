package com.socialmedia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.socialmedia.model.LikeModel;

public interface LikeDAO extends JpaRepository<LikeModel, String>{

	@Query(value = "select * from sm_like as lk where lk.post_id=?1",nativeQuery = true)
	List<LikeModel> getByPostId(String postId);

}

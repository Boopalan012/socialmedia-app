package com.socialmedia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.socialmedia.model.PostModel;

public interface PostDAO extends JpaRepository<PostModel, String> {
	@Query(value = "select * from sm_post as post where post.user_id=?1",nativeQuery = true)
	List<PostModel>getPostByUserId(String id);
}

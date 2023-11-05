package com.socialmedia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.socialmedia.model.CommentModel;

public interface CommentDAO extends JpaRepository<CommentModel, String> {
	@Query(value = "select * from sm_comment as cmt where cmt.post_id=?1",nativeQuery = true)
	List<CommentModel> getByPostId(String postId);

}

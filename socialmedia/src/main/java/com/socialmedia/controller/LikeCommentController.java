package com.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.JSON.LikeCommentJSON;
import com.socialmedia.JSON.LikeResponseJSON;
import com.socialmedia.service.PostService;
import com.socialmedia.utils.Response;

@RestController
public class LikeCommentController {
	@Autowired
	private PostService postService;
	
	@PostMapping("addlikeorcomment")
	private Response addLike(@RequestBody LikeCommentJSON LikeCommentJSON) {
		Response response=new Response();
		postService.addLikeOrComment(LikeCommentJSON);
		return response;
	}
	@PostMapping("addlike")
	private String addLike1(@RequestBody LikeResponseJSON LikeCommentJSON) {
		return "kjdfhh";
		}
	}

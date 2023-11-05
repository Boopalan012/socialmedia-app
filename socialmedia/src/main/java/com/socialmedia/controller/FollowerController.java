package com.socialmedia.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.JSON.UserJSON;
import com.socialmedia.service.UserDetailsService;
import com.socialmedia.utils.Response;

@RestController
@RequestMapping("/follower")
public class FollowerController {
	@Autowired
	private UserDetailsService userDetailsService;
	@GetMapping("/all-user")
	private Response getAllUser() {
		Response response=new Response();
		List<UserJSON> userJson=new ArrayList<UserJSON>();
		userDetailsService.getAllUserForUserModel(userJson,response);
		return response;
	}
	
	@GetMapping("/getuser-by-id")
	private Response getUserById(@RequestParam("id") String id) {
		Response response =new Response();
		UserJSON user= userDetailsService.getUserById(id);
		response.getData().add(user);
		return response;
	}
	
	@GetMapping("/follow-user")
	private Response followUser(@RequestParam("userId")String userId,@RequestParam("followerId")String followerId) {
		Response response=new Response();
		userDetailsService.followUser(userId,followerId);
		return response;
	}
	@GetMapping("/getfollowerlistById")
	private Response getfollowerListId(@RequestParam("id") String id) {
		Response response =new Response();
//		userDetailsService.getFollowerListByid(id,response);
		return response;
	}
	@GetMapping("/getfollowinglistById")
	private Response getfollowingListId(@RequestParam("id") String id) {
		Response response =new Response();
//		userDetailsService.getfollowngListBytId(id,response);
		return response;
	}
	
	
}

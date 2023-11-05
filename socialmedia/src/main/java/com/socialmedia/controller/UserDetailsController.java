package com.socialmedia.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.socialmedia.JSON.UserDetailsJson;
import com.socialmedia.model.UserDetailsModel;
import com.socialmedia.service.UserDetailsService;
import com.socialmedia.utils.Response;

@RestController
@RequestMapping("/userdetails")
public class UserDetailsController {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@PostMapping(value = "/adddetails" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	private Response addDetails(
			@RequestParam("profilepic")MultipartFile profilepic,
			@RequestParam("coverpic")MultipartFile coverPic,
		UserDetailsModel userDetails) throws IOException {
		// Your implementation here



		Response response=new Response();
		userDetailsService.saveUserDetails(userDetails,profilepic,coverPic,response);
		UserDetailsModel um=new UserDetailsModel();
	
		
		return response;
	}
}

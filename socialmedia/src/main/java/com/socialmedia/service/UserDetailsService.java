package com.socialmedia.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.socialmedia.JSON.PostJSON;
import com.socialmedia.JSON.UserJSON;
import com.socialmedia.dao.FollowerDAO;
import com.socialmedia.dao.LoginDao;
import com.socialmedia.dao.UserDetailsDao;
import com.socialmedia.model.FollowerModel;
import com.socialmedia.model.LoginModel;
import com.socialmedia.model.UserDetailsModel;
import com.socialmedia.utils.AppUtils;
import com.socialmedia.utils.Response;

@Service
public class UserDetailsService {
	
	@Autowired
	private UserDetailsDao userDetailsDao;
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private FollowerDAO followerDao;
	
	

	public void saveUserDetails(UserDetailsModel userDetails, MultipartFile profilepic, MultipartFile coverPic, Response response) throws IOException {
		// TODO Auto-generated method stub
		userDetails.setId(AppUtils.getRandomUUID());
		userDetails.setProfilePic(AppUtils.MutiPartToBase64(profilepic));
		userDetails.setCoverPic(AppUtils.MutiPartToBase64(coverPic));
		userDetailsDao.save(userDetails);
		}
	
	public void getAllUserForUserModel(List<UserJSON> userJson, Response response) {
		List<LoginModel> user=loginDao.findAll();
		for (LoginModel loginModel : user) {
			UserJSON userjson=new UserJSON();
			String id=loginModel.getId();
			UserDetailsModel userDetails=userDetailsDao.findByuserId(id);
			userjson.setUser(loginModel);
			userjson.setUserdetails(userDetails);
			userJson.add(userjson);
			
			
		}
		response.getData().add(userJson);
		
	}

	public UserJSON getUserById(String id) {
		// TODO Auto-generated method stub
		UserJSON userjson=new UserJSON();
		LoginModel loginModel=loginDao.findByuserId(id);
		if (loginModel!=null) {
			UserDetailsModel userDetails=userDetailsDao.findByuserId(loginModel.getId());
			userjson.setUserdetails(userDetails);
		}
		
		userjson.setUser(loginModel);
		
		return userjson;
	}

	public void followUser(String userId, String followerId) {
		FollowerModel followerModel=new FollowerModel();
		followerModel.setId(AppUtils.getRandomUUID());
		followerModel.setUserId(userId);
		followerModel.setFollowerId(followerId);
		followerDao.save(followerModel);
	}

	public List<FollowerModel> getFollowerListByid(String id) {
		// TODO Auto-generated method stub
		//need to check change
		List<FollowerModel> followerList =followerDao.getByuserId(id);
		List<UserJSON> user=new ArrayList<UserJSON>();
		for (FollowerModel followerModel : followerList) {
			UserJSON userjson=getUserById(followerModel.getFollowerId());
			user.add(userjson);
		}
		return followerList;
		
	}
	public List<UserJSON> getfollowingListBytId(String id) {
		List<FollowerModel> followingList =followerDao.getByuserId(id);
		List<UserJSON> user=new ArrayList<UserJSON>();
		for (FollowerModel followerModel : followingList) {
			UserJSON userjson=getUserById(followerModel.getFollowerId());
			user.add(userjson);
		}
		return user;
	}




}

package com.socialmedia.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.socialmedia.controller.LoginController;
import com.socialmedia.dao.LoginDao;
import com.socialmedia.model.LoginModel;
import com.socialmedia.utils.AppUtils;
import com.socialmedia.utils.Regex;
import com.socialmedia.utils.Response;



@Service
public class LoginService {
	private  Logger log = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	private LoginDao loginDao;

	public void saveUser(LoginModel loginModel, Response response) {
		List<Object> user=new ArrayList<Object>();
		loginModel.setId(AppUtils.getRandomUUID());
		loginModel.setPassword(AppUtils.encodePassword(loginModel.getPassword()));
		loginModel.setActive(true);
		loginModel.setUserDetailsRequired(true);
		LoginModel savedUser=loginDao.save(loginModel);
		if (savedUser!=null) {
			user.add(savedUser);
			response.setData(user);
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("User Saved Successfully");
		}
		
	}

	public LoginModel findByEmail(LoginModel loginModel, Response response) {
		// TODO Auto-generated method stub
		List<Object> user=new ArrayList<Object>();
		LoginModel result=loginDao.findByEmail(loginModel.getEmail());
		if (!AppUtils.decodeOassword(loginModel.getPassword(), result.getPassword())) {
			return null;
		}
		if (result!=null) {
			user.add(result);
			response.setData(user);
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("Login  Successfully");
		}
		return result;
		
	}

	public void validateSignUp(LoginModel loginModel, Response response) {
		// TODO Auto-generated method stub
		log.info("--------Start LoginService@validateSignUp------------");
		List<String> violation=new ArrayList<String>();
		if (loginModel!=null) {
			if (loginModel.getUsername()==null) {
				violation.add("User name is required");
			}
			if (AppUtils.validateRegex(Regex.EMAIL_REGEX,loginModel.getPassword())) {
				violation.add("email is invalid");
			}
			if (loginModel.getPassword()==null||loginModel.getPassword().isEmpty()) {
				violation.add("Password is required");
			}
		} else {
			violation.add("Login model is Null");
		}
		if (violation.size()>0) {
			response.setViolations(violation);
		}
		log.info("------End validateSignUp---------");
		
		
	}

	public void validateSignin(LoginModel loginModel, Response response) {
		// TODO Auto-generated method stub
		log.info("--------Start LoginService@validateSignin------------");
		List<String> violation=new ArrayList<String>();
		if (loginModel!=null) {
			if (AppUtils.validateRegex(Regex.EMAIL_REGEX,loginModel.getPassword())) {
				violation.add("email is invalid");
			}
			if (loginModel.getPassword()==null||loginModel.getPassword().isEmpty()) {
				violation.add("Password is required");
			}
		} else {
			violation.add("Login model is Null");
		}
		if (violation.size()>0) {
			response.setViolations(violation);
			response.setStatus(HttpStatus.BAD_REQUEST.value());
		}
		
	}

	


}

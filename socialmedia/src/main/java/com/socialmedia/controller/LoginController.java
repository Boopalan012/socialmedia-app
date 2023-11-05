package com.socialmedia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.dao.LoginDao;
import com.socialmedia.model.LoginModel;
import com.socialmedia.service.LoginService;
import com.socialmedia.utils.AppUtils;
import com.socialmedia.utils.Response;

@RestController
@RequestMapping("/login")
public class LoginController {
	private  Logger log = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private LoginService loginService;

	@Autowired
	private LoginDao loginDao;

	@PostMapping("/newuser")
	private Response loginNewUser(@RequestBody LoginModel loginModel) {
		log.info("------Start LoginController @loginNewUser-----------");
		Response response = new Response();
		loginService.validateSignUp(loginModel,response);
		if (response.getViolations().isEmpty()) {
			loginService.saveUser(loginModel,response);
			return response;
		}
		else {
			return response;
		}
	}
	@PostMapping("/olduser")
	private Response signupUser(@RequestBody LoginModel loginModel) {
		Response response=new Response();
		log.info("------Start LoginController @signupUser-----------");
		loginService.validateSignin(loginModel,response);
		if (response.getViolations().isEmpty()) {
			loginService.findByEmail(loginModel,response);
			return response;
		} else {
			return response;
		}
		
		
	}

}

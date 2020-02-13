package com.appsdeveloperblog.app.ws.ui.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.app.ws.shared.Utils;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appsdeveloperblog.app.ws.ui.userservice.UserService;

@Service
public class UserServiceImpl implements UserService{
	Map<String, UserRest> users;
	
	Utils utils;
	
	public UserServiceImpl() {}
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}

	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		// TODO Auto-generated method stub
		UserRest res = new UserRest();
		res.setFirstName(userDetails.getFirstName());
		res.setLastName(userDetails.getLastName());
		res.setEmail(userDetails.getEmail());
	
		String userId = utils.generateUserId();
		res.setUserId(userId);
		
		if (users == null) users = new HashMap<>();
		users.put(userId, res);	
		return res;
	}

}

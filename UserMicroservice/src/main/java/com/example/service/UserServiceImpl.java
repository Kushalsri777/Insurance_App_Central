package com.example.service;

import com.example.models.ForgetPasswordRequest;
import com.example.models.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.entities.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean addUserToSystem(User user) {
		return userDao.addUser(user);
	}

	@Override
	public boolean userLogin(LoginRequest loginRequest) {
		return userDao.userLogin(loginRequest);
	}

	@Override
	public boolean forgetPassword(ForgetPasswordRequest forgetPasswordRequest) {
		return userDao.forgetPassword(forgetPasswordRequest);
	}

//	@Override
//	public User getUserFromSystem(Integer userId) {
//		return userDao.getUser(userId);
//	}

}

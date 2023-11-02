package com.example.dao;

import com.example.entities.User;
import com.example.models.ForgetPasswordRequest;
import com.example.models.LoginRequest;

public interface UserDao {
	boolean addUser(final User user);
//	User getUser(final Integer userId);
	boolean userLogin(final LoginRequest loginRequest);
	boolean forgetPassword(final ForgetPasswordRequest forgetPasswordRequest);
}

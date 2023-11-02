package com.example.service;

import com.example.entities.User;
import com.example.models.ForgetPasswordRequest;
import com.example.models.LoginRequest;

public interface UserService {
	boolean addUserToSystem(final User user);
//	User getUserFromSystem(final Integer userId);
	boolean userLogin(final LoginRequest loginRequest);
	boolean forgetPassword(final ForgetPasswordRequest forgetPasswordRequest);
}

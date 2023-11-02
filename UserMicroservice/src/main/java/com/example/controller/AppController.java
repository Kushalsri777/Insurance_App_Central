package com.example.controller;

import com.example.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/authenticate")
public class AppController {
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest loginRequest) {
		System.out.println("--------");
		System.out.println(loginRequest);
		if(userService.userLogin(loginRequest)){
			return LoginResponse.builder().userLoginResponse(true).build();
		}
		return LoginResponse.builder().userLoginResponse(false).build();
	}

	@PostMapping("/registration")
	public RegisterationResponse register(@RequestBody RegisterationRequest registerationRequest) {
		if(userService.addUserToSystem(User.builder()
				.userId(registerationRequest.getUserId())
				.username(registerationRequest.getUsername())
				.firstName(registerationRequest.getFirstName())
				.lastName(registerationRequest.getLastName())
				.nickName(registerationRequest.getNickName())
				.gender(registerationRequest.getGender())
				.userType(registerationRequest.getUserType())
				.companyName(registerationRequest.getCompanyName())
				.gstinNo(registerationRequest.getGstinNo())
				.password(registerationRequest.getPassword())
				.phoneNo(registerationRequest.getPhoneNo()).build())
		) {

			return RegisterationResponse.builder().userRegisterationResponse(true).build();
		}

		return RegisterationResponse.builder().userRegisterationResponse(false).build();
	}

	@PostMapping("/forgetPassword")
	public String forgetPassword(@RequestBody ForgetPasswordRequest forgetPasswordRequest) {
		if(userService.forgetPassword(forgetPasswordRequest)){
			return "Password Reset Successfully";
		}
		return "Try Again";
	}
}

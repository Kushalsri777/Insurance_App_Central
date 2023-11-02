package com.example.dao;

import com.example.models.ForgetPasswordRequest;
import com.example.models.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entities.User;
import com.example.repo.UserTableRepo;

import java.util.Objects;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private UserTableRepo userTableRepo;

	@Override
	public boolean addUser(final User user) {
		userTableRepo.save(user);
		return true;
	}

	@Override
	public boolean userLogin(final LoginRequest loginRequest) {
		User user = userTableRepo.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        return user != null;
    }

	@Override
	public boolean forgetPassword(ForgetPasswordRequest forgetPasswordRequest) {
		User user = userTableRepo.findByUsernameAndNickName(forgetPasswordRequest.getUsername(), forgetPasswordRequest.getNickName());
		if(user == null || Objects.equals(user.getPassword(), forgetPasswordRequest.getNewPassword())){
			return false;
		}
		//if oldPassword == newPassword then throw custom exception
		user.setPassword(forgetPasswordRequest.getNewPassword());
		userTableRepo.save(user);
		return true;
	}

//	@Override
//	public User getUser(final Integer userId) {
//		return userTableRepo.findById(userId).get();
//	}

}

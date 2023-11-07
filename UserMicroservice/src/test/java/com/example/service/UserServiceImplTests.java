package com.example.service;

import com.example.dao.UserDao;
import com.example.models.ForgetPasswordRequest;
import com.example.models.LoginRequest;
import com.example.entities.User;
import com.example.service.UserService;
import com.example.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceImplTests {
    @InjectMocks
    private UserService userService = new UserServiceImpl();
    @Mock
    private UserDao userDao;

    @BeforeEach
    public void beforeTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addUserToSystemTest() {
        User user = new User();
        when(userDao.addUser(user)).thenReturn(true);
        boolean result = userService.addUserToSystem(user);
        assertTrue(result);
        verify(userDao, times(1)).addUser(user);
    }

    @Test
    public void userLogin_SuccessTest() {
        LoginRequest loginRequest = new LoginRequest("adi", "pwd");
        when(userDao.userLogin(loginRequest)).thenReturn(true);
        boolean result = userService.userLogin(loginRequest);
        assertTrue(result);
    }

    @Test
    public void userLogin_FailedTest() {
        LoginRequest loginRequest = new LoginRequest("adi", "pwd");
        when(userDao.userLogin(loginRequest)).thenReturn(false);
        boolean result = userService.userLogin(loginRequest);
        assertFalse(result);
    }

    @Test
    public void forgetPassword_SuccessTest() {
        ForgetPasswordRequest forgetPasswordRequest = new ForgetPasswordRequest("adi", "nickName", "pwd");
        when(userDao.forgetPassword(forgetPasswordRequest)).thenReturn(true);
        boolean result = userService.forgetPassword(forgetPasswordRequest);
        assertTrue(result);
    }

    @Test
    public void forgetPassword_FailedTest() {
        ForgetPasswordRequest forgetPasswordRequest = new ForgetPasswordRequest("adi", "nickName", "pwd");
        when(userDao.forgetPassword(forgetPasswordRequest)).thenReturn(false);
        boolean result = userService.forgetPassword(forgetPasswordRequest);
        assertFalse(result);
    }
}


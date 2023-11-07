package com.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.models.*;
import com.example.enums.UserType;
import com.example.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AppControllerTests {
        private MockMvc mockMvc;
        @InjectMocks
        private AppController appController;
        @Mock
        private UserService userService;

        @BeforeEach
        public void beforeTest() {
                MockitoAnnotations.openMocks(this);
                mockMvc = MockMvcBuilders.standaloneSetup(appController).build();
        }

        @Test
        public void loginTest() throws Exception {
                LoginRequest loginRequest = LoginRequest.builder()
                                .username("adi")
                                .password("pwd")
                                .build();

                when(userService.userLogin(loginRequest)).thenReturn(true);

                mockMvc.perform(post("/authenticate/login")
                                .contentType("application/json")
                                .content(new ObjectMapper().writeValueAsString(loginRequest)))
                                .andExpect(status().isOk())
                                .andExpect(content().json("{\"userLoginResponse\":true}"));
        }

        @Test
        public void registrationTest() throws Exception {
                RegistrationRequest registrationRequest = RegistrationRequest.builder()
                                .userId(1L)
                                .username("abc")
                                .firstName("xyz")
                                .lastName("pqr")
                                .phoneNo(1234567890L)
                                .userType(UserType.USER)
                                .gender("m")
                                .nickName("nickName")
                                .password("pwd")
                                .build();

                when(userService.addUserToSystem(any())).thenReturn(true);

                mockMvc.perform(post("/authenticate/registration")
                                .contentType("application/json")
                                .content(new ObjectMapper().writeValueAsString(registrationRequest)))
                                .andExpect(status().isOk())
                                .andExpect(content().json("{\"userRegistrationResponse\":true}"));
        }

        @Test
        public void forgetPasswordTest() throws Exception {
                ForgetPasswordRequest forgetPasswordRequest = ForgetPasswordRequest.builder()
                                .username("adi")
                                .nickName("nickName")
                                .newPassword("pwd")
                                .build();

                when(userService.forgetPassword(forgetPasswordRequest)).thenReturn(true);

                mockMvc.perform(post("/authenticate/forgetPassword")
                                .contentType("application/json")
                                .content(new ObjectMapper().writeValueAsString(forgetPasswordRequest)))
                                .andExpect(status().isOk())
                                .andExpect(content().string("Password Reset Successfully"));
        }

        @Test
        public void testDeleteUser() {
                Long userId = 1L;
                ResponseEntity<Object> response = appController.deleteUser(userId);
                assertEquals(200, response.getStatusCodeValue());
        }
}

package com.example.models;

import javax.persistence.GeneratedValue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoRequest {
	@GeneratedValue()
	private Long userId;
    private int age;
    private String city;
    private String medicalHistory;
    private boolean tobaccoUser;
    private boolean alcoholConsumer;
}

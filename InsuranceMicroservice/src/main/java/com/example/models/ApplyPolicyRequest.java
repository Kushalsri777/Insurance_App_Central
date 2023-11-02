package com.example.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplyPolicyRequest {

   @GeneratedValue()
    private Long policyId;
    private Long userId;
    private int age;
    private String city;
    private String medicalHistory;
    private boolean tobaccoUser;
    private boolean alcoholConsumer;
}

package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue()
    private Long userId;
    private int age;
    private String city;
    private String medicalHistory;
    private boolean tobaccoUser;
    private boolean alcoholConsumer;
    private Long policyId; // Foreign key to policy table
    private String policyName; 
}

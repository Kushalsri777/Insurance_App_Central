package com.example.entities;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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

public class Policy {

    @Id
    @GeneratedValue
    private int policyId;
    private String policyName;
    private String description;
    private double coverageAmount;
    private int premium;
    
}

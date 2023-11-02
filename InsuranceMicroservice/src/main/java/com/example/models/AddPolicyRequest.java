package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddPolicyRequest {

    private String policyName;
    private String description;
    private double coverageAmount;
    private int premium;
}

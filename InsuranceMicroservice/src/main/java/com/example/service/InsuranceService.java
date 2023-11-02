package com.example.service;

import java.util.List;

import com.example.entities.Policy;
import com.example.models.AddPolicyRequest;
import com.example.models.ApplyPolicyRequest;
import com.example.models.ProvideInfoRequest;
import com.example.models.RegisterCompanyRequest;
import com.example.models.UserInfoRequest;

public interface InsuranceService {

    // User Operations
    String applyPolicy(ApplyPolicyRequest request);
    String provideInfo(UserInfoRequest request);
    List<Policy> getAllPolicies();

    // Admin Operations
    String registerCompany(RegisterCompanyRequest request);
    String addPolicy(AddPolicyRequest request);
    String updatePolicy(int policyId, AddPolicyRequest request);

    // Owner Operations
    String provideInfoToBuyers(ProvideInfoRequest request);
    String provideInfoToCompanies(ProvideInfoRequest request);
	
}

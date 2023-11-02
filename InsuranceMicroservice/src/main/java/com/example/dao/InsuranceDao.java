package com.example.dao;

import com.example.models.AddPolicyRequest;
import com.example.models.ApplyPolicyRequest;
import com.example.models.ProvideInfoRequest;
import com.example.models.RegisterCompanyRequest;
import com.example.models.UserInfoRequest;

import java.util.List;

import com.example.entities.Policy;

public interface InsuranceDao {

    // User Operations
    String applyPolicy(ApplyPolicyRequest request);
    String provideInfo(UserInfoRequest request);
//    List<String> getAddOnFeatures(int policyId);
    List<Policy> getAllPolicies();

    // Admin Operations
    String registerCompany(RegisterCompanyRequest request);
    String addPolicy(AddPolicyRequest request);
    String updatePolicy(int policyId, AddPolicyRequest request);

    // Owner Operations
    String provideInfoToBuyers(ProvideInfoRequest request);
    String provideInfoToCompanies(ProvideInfoRequest request);
}

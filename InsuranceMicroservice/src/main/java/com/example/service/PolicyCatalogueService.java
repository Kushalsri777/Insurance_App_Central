package com.example.service;

import java.util.List;

import com.example.entity.PolicyCatalogue;

public interface PolicyCatalogueService {
    public void addPolicy(PolicyCatalogue policy);

    public Boolean deletePolicy(Long id);

    public List<PolicyCatalogue> getAllPolicies();

    public PolicyCatalogue findPolicyById(Long id);
}

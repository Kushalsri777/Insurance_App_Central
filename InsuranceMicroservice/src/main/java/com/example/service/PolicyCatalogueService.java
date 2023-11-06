package com.example.service;

import java.util.List;

import com.example.entity.PolicyCatalogue;

public interface PolicyCatalogueService {
    public String buyPolicy();
    public List<PolicyCatalogue> getAllPolicies();
    public PolicyCatalogue findPolicyById(Long id);
}

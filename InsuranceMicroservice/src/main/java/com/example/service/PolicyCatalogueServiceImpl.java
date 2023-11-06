package com.example.service;

import com.example.entity.PolicyCatalogue;
import com.example.repo.PolicyCatalogueRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyCatalogueServiceImpl implements PolicyCatalogueService {

    @Autowired
    private PolicyCatalogueRepo pRepo;

    @Override
    public String buyPolicy() {
        //Calls Cart MicroService
        return "Policy Bought";
    }

    @Override
    public List<PolicyCatalogue> getAllPolicies() {
       return (List<PolicyCatalogue>)pRepo.findAll();
    }

    @Override
    public PolicyCatalogue findPolicyById(Long id) {
       return  pRepo.findById(id).isPresent() ? pRepo.findById(id).get() : null;
    }

    
}

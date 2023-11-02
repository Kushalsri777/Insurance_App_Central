package com.example.controller;

import com.example.models.AddPolicyRequest;
import com.example.models.ApplyPolicyRequest;
import com.example.models.ProvideInfoRequest;
import com.example.models.RegisterCompanyRequest;
import com.example.models.UserInfoRequest;
import com.example.service.InsuranceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.entities.Policy;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @PostMapping("/applyPolicy")
    public String applyPolicy(@RequestBody ApplyPolicyRequest request) {
        return insuranceService.applyPolicy(request);
    }

    @PostMapping("/provideInfo")
    public String provideInfo(@RequestBody UserInfoRequest request) {
        return insuranceService.provideInfo(request);
    }
    
    @GetMapping("/getAllPolicies")
    public List<Policy> getAllPoliciesByPolicyId() {
        return insuranceService.getAllPolicies();
    }

    @PostMapping("/registerCompany")
    public String registerCompany(@RequestBody RegisterCompanyRequest request) {
        return insuranceService.registerCompany(request);
    }

    @PostMapping("/addPolicy")
    public String addPolicy(@RequestBody AddPolicyRequest request) {
        return insuranceService.addPolicy(request);
    }
    
    @PutMapping("/updatePolicy/{policyId}")
    public String updatePolicy(@PathVariable int policyId, @RequestBody AddPolicyRequest request) {
        return insuranceService.updatePolicy(policyId, request);
    }

    @PostMapping("/provideInfoToBuyers")
    public String provideInfoToBuyers(@RequestBody ProvideInfoRequest request) {
        return insuranceService.provideInfoToBuyers(request);
    }

    @PostMapping("/provideInfoToCompanies")
    public String provideInfoToCompanies(@RequestBody ProvideInfoRequest request) {
        return insuranceService.provideInfoToCompanies(request);
    }
}

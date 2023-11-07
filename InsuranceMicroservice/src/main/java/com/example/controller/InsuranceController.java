package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entity.PolicyCatalogue;
import com.example.service.PolicyCatalogueService;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    private PolicyCatalogueService service;

    @PostMapping("addpolicy")
    public ResponseEntity<Object> addPolicy(@RequestBody PolicyCatalogue policy) {
        service.addPolicy(policy);
        HttpHeaders header = new HttpHeaders();
        header.add("Policy-Id", policy.getPolicyId().toString());
        return ResponseEntity.ok()
                .headers(header)
                .body("Policy Added");
    }

    @DeleteMapping("/deletepolicy/{id}")
    public ResponseEntity<Object> deletePolicy(@PathVariable("id") Long id) {
        return Boolean.TRUE.equals(service.deletePolicy(id)) ? ResponseEntity.ok()
                .body("Deleted")
                : ResponseEntity.ok()
                        .body("User Not Found");
    }

    @GetMapping("/getallpolicies")
    public ResponseEntity<Object> getAllPolicies() {
        HttpHeaders header = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(header)
                .body(service.getAllPolicies());
    }

    @GetMapping("/getpolicybyid/{id}")
    public ResponseEntity<Object> findPolicyById(@PathVariable("id") Long id) {
        HttpHeaders header = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(header)
                .body(service.findPolicyById(id));
    }

}
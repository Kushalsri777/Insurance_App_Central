package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.service.PolicyCatalogueService;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    private PolicyCatalogueService service;

    @PostMapping("/buypolicy")
    public ResponseEntity<Object> buyPolicy(){
        HttpHeaders header = new HttpHeaders();
        return ResponseEntity.ok()
        .headers(header)
        .body("Done");
    }

    @GetMapping("/getallpolicies")
    public ResponseEntity<Object> getAllPolicies(){
        HttpHeaders header = new HttpHeaders();
        return ResponseEntity.ok()
        .headers(header)
        .body(service.getAllPolicies());
    }

    @GetMapping("/getpolicybyid/{id}")
    public ResponseEntity<Object> findPolicyById(@PathVariable Long id){
        HttpHeaders header = new HttpHeaders();
        return ResponseEntity.ok()
        .headers(header)
        .body(service.findPolicyById(id));
    }

}
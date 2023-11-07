package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.example.constants.UriConstants;
import com.example.entity.PolicyCatalogue;
import com.example.model.AllItemsInCartResponse;
import com.example.model.CreateOrderFromCartRequest;
import com.example.model.CreateOrderFromCartResponse;
import com.example.service.PolicyCatalogueService;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    private PolicyCatalogueService service;
    @Autowired
    private RestTemplate restTemplate;
    
    @PostMapping("/buypolicy/{userId}")
    public ResponseEntity<Object> buyPolicy(@PathVariable final int userId){
    	AllItemsInCartResponse cartItemsResponseBody = restTemplate.getForEntity(String.format(
    			String.format(UriConstants.GET_ALL_ITEMS_FROM_CART_URL, userId), userId), 
    			AllItemsInCartResponse.class).getBody();
    	restTemplate.postForEntity(UriConstants.CREATE_ORDER_FROM_CART_URL, CreateOrderFromCartRequest.builder()
    			.userId(userId).isPaymentDone(Boolean.TRUE).build(), CreateOrderFromCartResponse.class);
        HttpHeaders header = new HttpHeaders();
        return ResponseEntity.ok().headers(header).body("DONE !!");
    }

    @GetMapping("/getallpolicies")
    public ResponseEntity<Object> getAllPolicies(){
        HttpHeaders header = new HttpHeaders();
        return ResponseEntity.ok()
        .headers(header)
        .body(service.getAllPolicies());
    }

    @PostMapping("addpolicy")
    public ResponseEntity<Object> addPolicy(@RequestBody PolicyCatalogue policy) {
        service.addPolicy(policy);
        return ResponseEntity.ok()
                .body("Policy Added");
    }

    @DeleteMapping("/deletepolicy/{id}")
    public ResponseEntity<Object> deletePolicy(@PathVariable("id") Long id) {
        return Boolean.TRUE.equals(service.deletePolicy(id)) ? ResponseEntity.ok()
                .body("Deleted")
                : ResponseEntity.ok()
                        .body("User Not Found");
    }

    @GetMapping("/getpolicybyid/{id}")
    public ResponseEntity<Object> findPolicyById(@PathVariable("id") Long id) {
        HttpHeaders header = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(header)
                .body(service.findPolicyById(id));
    }

}
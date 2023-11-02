package com.example.controller;

import com.example.handler.InsuranceCartHandler;
import com.example.model.AddPolicyToCartRequest;
import com.example.model.AddPolicyToCartResponse;
import com.example.model.DeletePolicyFromCartRequest;
import com.example.model.DeletePolicyFromCartResponse;
import com.example.model.CreateOrderFromCartResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/insurance/cart")
public class AppController {

    @Autowired
    private InsuranceCartHandler insuranceCartHandler;

    @PostMapping("/addPolicyToCart")
    public AddPolicyToCartResponse addPolicyToCart(@RequestBody final AddPolicyToCartRequest addPolicyToCartRequest) {
        return insuranceCartHandler.addPolicyToCart(addPolicyToCartRequest);
    }

    @DeleteMapping("/deletePolicyFromCart")
    public DeletePolicyFromCartResponse deletePolicyFromCart(@RequestBody final DeletePolicyFromCartRequest deletePolicyFromCartRequest) {
        return insuranceCartHandler.deletePolicyFromCart(deletePolicyFromCartRequest);
    }

    @GetMapping("/createOrder/{userId}")
    public CreateOrderFromCartResponse createOrder(@PathVariable final int userId) {
        return insuranceCartHandler.createOrderFromCart(userId);
    }
}

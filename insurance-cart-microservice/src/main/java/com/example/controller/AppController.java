package com.example.controller;

import com.example.handler.InsuranceCartHandler;
import com.example.model.AllItemsInCartResponse;
import com.example.model.AddPolicyToCartRequest;
import com.example.model.AddPolicyToCartResponse;
import com.example.model.DeletePolicyFromCartRequest;
import com.example.model.DeletePolicyFromCartResponse;
import com.example.model.CreateOrderFromCartResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<AddPolicyToCartResponse> addPolicyToCart(@RequestBody final AddPolicyToCartRequest addPolicyToCartRequest) {
        return ResponseEntity.ok().body(insuranceCartHandler.addPolicyToCart(addPolicyToCartRequest));
    }

    @DeleteMapping("/deletePolicyFromCart")
    public ResponseEntity<DeletePolicyFromCartResponse> deletePolicyFromCart(@RequestBody final DeletePolicyFromCartRequest deletePolicyFromCartRequest) {
        return ResponseEntity.ok().body(insuranceCartHandler.deletePolicyFromCart(deletePolicyFromCartRequest));
    }

    @DeleteMapping("/clearCart/{userId}")
    public void clearCartForUser(@PathVariable final int userId) {
        insuranceCartHandler.clearCartForUser(userId);
    }

    @GetMapping("/getAllItemsFromCart/{userId}")
    public ResponseEntity<AllItemsInCartResponse> getAllItemsFromCart(@PathVariable final int userId) {
        return ResponseEntity.ok().body(insuranceCartHandler.getAllItemsFromCart(userId));
    }

    @GetMapping("/createOrder/{userId}")
    public ResponseEntity<CreateOrderFromCartResponse> createOrder(@PathVariable final int userId) {
        return ResponseEntity.ok().body(insuranceCartHandler.createOrderFromCart(userId));
    }
}

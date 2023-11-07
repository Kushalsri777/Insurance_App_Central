package com.example.controller;

import com.example.handler.InsuranceCartHandler;
import com.example.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class AppControllerTests {
    @InjectMocks
    private AppController appController;
    @Mock
    private InsuranceCartHandler insuranceCartHandler;

    @BeforeEach
    public void beforeTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addPolicyToCartTest() {
        AddPolicyToCartRequest request = AddPolicyToCartRequest.builder()
                .userId(1)
                .policyId(100)
                .build();
        AddPolicyToCartResponse response = AddPolicyToCartResponse.builder()
                .isPolicyAddedSuccessfully(true)
                .build();
        when(insuranceCartHandler.addPolicyToCart(request)).thenReturn(response);
        ResponseEntity<AddPolicyToCartResponse> result = appController.addPolicyToCart(request);
        assertNotNull(result);
        assertEquals(response, result.getBody());
    }

    @Test
    public void deletePolicyFromCartTest() {
        DeletePolicyFromCartRequest request = DeletePolicyFromCartRequest.builder()
                .userId(1)
                .policyId(100)
                .build();
        DeletePolicyFromCartResponse response = DeletePolicyFromCartResponse.builder()
                .isPolicyDeleteSuccessfully(true)
                .build();
        when(insuranceCartHandler.deletePolicyFromCart(request)).thenReturn(response);
        ResponseEntity<DeletePolicyFromCartResponse> result = appController.deletePolicyFromCart(request);
        assertNotNull(result);
        assertEquals(response, result.getBody());
    }

    @Test
    public void clearCartForUserTest() {
        int userId = 1;
        appController.clearCartForUser(userId);
        verify(insuranceCartHandler, times(1)).clearCartForUser(userId);
    }

    @Test
    public void getAllItemsFromCartTest() {
        int userId = 1;
        AllItemsInCartResponse response = AllItemsInCartResponse.builder()
                .userId(userId)
                .listOfPolicyIds(List.of(101, 102, 103))
                .build();
        when(insuranceCartHandler.getAllItemsFromCart(userId)).thenReturn(response);
        ResponseEntity<AllItemsInCartResponse> result = appController.getAllItemsFromCart(userId);
        assertNotNull(result);
        assertEquals(response, result.getBody());
    }

    @Test
    public void createOrderFromCartTest() {
        int userId = 1;
        CreateOrderFromCartResponse response = CreateOrderFromCartResponse.builder()
                .isOrderCreated(true)
                .build();
        when(insuranceCartHandler.createOrderFromCart(userId)).thenReturn(response);
        ResponseEntity<CreateOrderFromCartResponse> result = appController.createOrder(userId);
        assertNotNull(result);
        assertEquals(response, result.getBody());
    }
}

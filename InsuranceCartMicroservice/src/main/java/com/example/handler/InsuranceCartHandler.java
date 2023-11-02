package com.example.handler;

import com.example.model.*;

public interface InsuranceCartHandler {
    public abstract AddPolicyToCartResponse addPolicyToCart(final AddPolicyToCartRequest addPolicyToCartRequest);
    public abstract DeletePolicyFromCartResponse deletePolicyFromCart(final DeletePolicyFromCartRequest deletePolicyFromCartRequest);
    public abstract CreateOrderFromCartResponse createOrderFromCart(final Integer userId);
}

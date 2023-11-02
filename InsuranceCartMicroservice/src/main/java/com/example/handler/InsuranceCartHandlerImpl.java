package com.example.handler;

import com.example.dao.CartDao;
import com.example.dao.OrdersDao;
import com.example.entity.Cart;
import com.example.entity.Orders;
import com.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceCartHandlerImpl implements InsuranceCartHandler {
    @Autowired
    private CartDao cartDao;
    @Autowired
    private OrdersDao ordersDao;

    @Override
    public AddPolicyToCartResponse addPolicyToCart(final AddPolicyToCartRequest addPolicyToCartRequest) {
        cartDao.saveItemToCart(Cart.builder()
                        .userId(addPolicyToCartRequest.getUserId())
                        .policyId(addPolicyToCartRequest.getPolicyDetails().getPolicyId())
                        .policyDetail(addPolicyToCartRequest.getPolicyDetails().toString())
                .build());
        return AddPolicyToCartResponse.builder()
                .isPolicyAddedSuccessfully(Boolean.TRUE).build();
    }

    @Override
    public DeletePolicyFromCartResponse deletePolicyFromCart(final DeletePolicyFromCartRequest deletePolicyFromCartRequest) {
        cartDao.deleteItemFromCart(deletePolicyFromCartRequest.getUserId(), deletePolicyFromCartRequest.getPolicyId());
        return DeletePolicyFromCartResponse.builder().isPolicyDeleteSuccessfully(true).build();
    }


    @Override
    public CreateOrderFromCartResponse createOrderFromCart(final Integer userId) {
        List<Cart> listOfCartItems = cartDao.getAllItemsForUser(userId);
        ordersDao.addOrder(Orders.builder()
                .userId(userId)
                .policyDetails(listOfCartItems.toString())
                .build());
        cartDao.removeListOfItems(listOfCartItems);
        return CreateOrderFromCartResponse.builder().isOrderCreated(true).build();
    }
}

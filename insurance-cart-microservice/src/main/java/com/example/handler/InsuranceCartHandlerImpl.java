package com.example.handler;

import com.example.dao.CartItemsDao;
import com.example.dao.OrdersDao;
import com.example.entity.CartItems;
import com.example.entity.Orders;
import com.example.model.AddPolicyToCartRequest;
import com.example.model.AddPolicyToCartResponse;
import com.example.model.CreateOrderFromCartResponse;
import com.example.model.DeletePolicyFromCartResponse;
import com.example.model.DeletePolicyFromCartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsuranceCartHandlerImpl implements InsuranceCartHandler {
    @Autowired
    private CartItemsDao cartDao;
    @Autowired
    private OrdersDao ordersDao;

    @Override
    public AddPolicyToCartResponse addPolicyToCart(final AddPolicyToCartRequest addPolicyToCartRequest) {
        cartDao.saveItemToCart(CartItems.builder()
                        .userId(addPolicyToCartRequest.getUserId())
                        .policyId(addPolicyToCartRequest.getPolicyId())
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
        List<CartItems> listOfCartItems = cartDao.getAllItemsForUser(userId);
        ordersDao.addOrder(Orders.builder()
                .userId(userId)
                .isPaymentDone(Boolean.FALSE)
                .policyIds(listOfCartItems.stream().map(CartItems::getPolicyId).collect(Collectors.toList()))
                .build());
        cartDao.removeListOfItems(listOfCartItems);
        return CreateOrderFromCartResponse.builder().isOrderCreated(true).build();
    }

    @Override
    @Transactional
    public void clearCartForUser(Integer userId) {
        cartDao.clearCartForUser(userId);
    }
}

package com.example.handler;

import com.example.dao.CartItemsDao;
import com.example.dao.OrdersDao;
import com.example.entity.CartItems;
import com.example.entity.Orders;
import com.example.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class InsuranceCartHandlerImplTests {
    @InjectMocks
    private InsuranceCartHandler insuranceCartHandler = new InsuranceCartHandlerImpl();
    @Mock
    private CartItemsDao cartDao;
    @Mock
    private OrdersDao ordersDao;

    @BeforeEach
    public void beforeTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addPolicyToCartTest() {
        AddPolicyToCartRequest request = AddPolicyToCartRequest.builder()
                .userId(1)
                .policyId(101)
                .build();
        doNothing().when(cartDao).saveItemToCart(any(CartItems.class));
        AddPolicyToCartResponse expectedResponse = AddPolicyToCartResponse.builder()
                .isPolicyAddedSuccessfully(true)
                .build();
        AddPolicyToCartResponse result = insuranceCartHandler.addPolicyToCart(request);
        assertNotNull(result);
        assertEquals(expectedResponse, result);
    }

    @Test
    public void deletePolicyFromCartTest() {
        DeletePolicyFromCartRequest request = DeletePolicyFromCartRequest.builder()
                .userId(1)
                .policyId(101)
                .build();
        doNothing().when(cartDao).deleteItemFromCart(1, 101);
        DeletePolicyFromCartResponse expectedResponse = DeletePolicyFromCartResponse.builder()
                .isPolicyDeleteSuccessfully(true)
                .build();
        DeletePolicyFromCartResponse result = insuranceCartHandler.deletePolicyFromCart(request);
        assertNotNull(result);
        assertEquals(expectedResponse, result);
    }

    @Test
    public void createOrderFromCartTest() {
        int userId = 1;
        List<CartItems> cartItemsList = Arrays.asList(
                CartItems.builder().userId(userId).policyId(101).build(),
                CartItems.builder().userId(userId).policyId(102).build()
        );
        doNothing().when(cartDao).removeListOfItems(cartItemsList);
        doAnswer((Answer<Void>) i -> {
            Orders order = (Orders) i.getArguments()[0];
            order.setOrderId(1);
            return null;
        }).when(ordersDao).addOrder(any(Orders.class));
        CreateOrderFromCartResponse expectedResponse = CreateOrderFromCartResponse.builder()
                .isOrderCreated(true)
                .build();
        CreateOrderFromCartResponse result = insuranceCartHandler.createOrderFromCart(userId);
        assertNotNull(result);
        assertEquals(expectedResponse, result);
    }

    @Test
    public void clearCartForUserTest() {
        int userId = 1;
        doNothing().when(cartDao).clearCartForUser(userId);
        insuranceCartHandler.clearCartForUser(userId);
        verify(cartDao, times(1)).clearCartForUser(userId);
    }

    @Test
    public void getAllItemsFromCartTest() {
        int userId = 1;
        List<CartItems> cartItemsList = Arrays.asList(
                CartItems.builder().userId(userId).policyId(101).build(),
                CartItems.builder().userId(userId).policyId(102).build()
        );
        when(cartDao.getAllItemsForUser(userId)).thenReturn(cartItemsList);
        AllItemsInCartResponse expectedResponse = AllItemsInCartResponse.builder()
                .userId(userId)
                .listOfPolicyIds(Arrays.asList(101, 102))
                .build();
        AllItemsInCartResponse result = insuranceCartHandler.getAllItemsFromCart(userId);
        assertNotNull(result);
        assertEquals(expectedResponse, result);
    }
}

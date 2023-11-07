package com.example.dao;

import com.example.entity.CartItems;
import com.example.repo.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CartItemsDaoImplTests {
    @InjectMocks
    private CartItemsDao cartItemsDao = new CartItemsDaoImpl();
    @Mock
    private CartRepository cartRepository;

    @BeforeEach
    public void beforeTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveItemToCartTest() {
        CartItems cartItem = CartItems.builder()
                .userId(1)
                .policyId(101)
                .build();

        cartItemsDao.saveItemToCart(cartItem);

        verify(cartRepository, times(1)).save(cartItem);
    }

    @Test
    public void deleteItemFromCartTest() {
        int userId = 1;
        int policyId = 101;

        cartItemsDao.deleteItemFromCart(userId, policyId);

        verify(cartRepository, times(1)).deleteByPolicyId(userId, policyId);
    }

    @Test
    public void getAllItemsForUserTest() {
        int userId = 1;
        List<CartItems> cartItemsList = new ArrayList<>();
        cartItemsList.add(CartItems.builder().userId(userId).policyId(101).build());
        cartItemsList.add(CartItems.builder().userId(userId).policyId(102).build());

        when(cartRepository.getListOfItemsForUserId(userId)).thenReturn(cartItemsList);

        List<CartItems> result = cartItemsDao.getAllItemsForUser(userId);

        assertNotNull(result);
        assertEquals(cartItemsList, result);
    }

    @Test
    public void removeListOfItemsTest() {
        List<CartItems> cartItemsList = new ArrayList<>();
        cartItemsList.add(CartItems.builder().userId(1).policyId(101).build());
        cartItemsList.add(CartItems.builder().userId(2).policyId(102).build());
        cartItemsDao.removeListOfItems(cartItemsList);
        verify(cartRepository, times(1)).deleteAll(cartItemsList);
    }

    @Test
    public void clearCartForUserTest() {
        int userId = 1;
        cartItemsDao.clearCartForUser(userId);
        verify(cartRepository, times(1)).deleteAllByUserId(userId);
    }
}

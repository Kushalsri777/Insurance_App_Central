package com.example.dao;

import com.example.entity.CartItems;
import com.example.repo.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CartItemsDaoImpl implements CartItemsDao {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public void saveItemToCart(final CartItems cart) {
        cartRepository.save(cart);
    }

    @Override
    @Transactional
    public void deleteItemFromCart(final Integer userId, final Integer policyId) {
        cartRepository.deleteByPolicyId(userId, policyId);
    }

    @Override
    public List<CartItems> getAllItemsForUser(final Integer userId) {
        return cartRepository.getListOfItemsForUserId(userId);
    }

    @Override
    public void removeListOfItems(List<CartItems> listOfItems) {
        cartRepository.deleteAll(listOfItems);
    }

    @Override
    public void clearCartForUser(Integer userId) {
        cartRepository.deleteAllByUserId(userId);
    }
}

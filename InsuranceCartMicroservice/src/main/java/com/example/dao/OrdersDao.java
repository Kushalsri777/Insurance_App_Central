package com.example.dao;


import com.example.entity.Orders;

public interface OrdersDao {
    public abstract Boolean addOrder(final Orders order);
}

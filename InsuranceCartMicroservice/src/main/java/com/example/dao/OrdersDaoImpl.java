package com.example.dao;

import com.example.entity.Orders;
import com.example.repo.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDaoImpl implements OrdersDao {
    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public Boolean addOrder(Orders order) {
        ordersRepository.save(order);
        return true;
    }
}

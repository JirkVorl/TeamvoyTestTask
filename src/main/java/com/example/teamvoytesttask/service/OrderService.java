package com.example.teamvoytesttask.service;

import com.example.teamvoytesttask.model.Order;
import com.example.teamvoytesttask.model.ShoppingCart;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);
}

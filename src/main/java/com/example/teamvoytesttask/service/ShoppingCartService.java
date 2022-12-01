package com.example.teamvoytesttask.service;

import com.example.teamvoytesttask.model.Product;
import com.example.teamvoytesttask.model.ShoppingCart;
import com.example.teamvoytesttask.model.User;

public interface ShoppingCartService {
    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);

    void addProduct(Product product, User user);

}

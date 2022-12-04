package com.example.teamvoytesttask.service.impl;

import com.example.teamvoytesttask.model.Product;
import com.example.teamvoytesttask.model.ShoppingCart;
import com.example.teamvoytesttask.model.User;
import com.example.teamvoytesttask.repository.ShoppingCartRepository;
import com.example.teamvoytesttask.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartRepository.findByUser(user).orElseThrow(
                () -> new RuntimeException("Shopping cart by user " + user + " not found"));
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.setProducts(null);
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void addProduct(Product product, User user) {
        ShoppingCart shoppingCart = shoppingCartRepository.findByUser(user).orElseThrow(
                () -> new RuntimeException("Can't get shopping cart by user " + user));
        shoppingCart.getProducts().add(product);
        shoppingCartRepository.save(shoppingCart);
    }
}

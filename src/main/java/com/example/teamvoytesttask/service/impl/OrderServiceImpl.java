package com.example.teamvoytesttask.service.impl;

import com.example.teamvoytesttask.model.Order;
import com.example.teamvoytesttask.model.Product;
import com.example.teamvoytesttask.model.ShoppingCart;
import com.example.teamvoytesttask.repository.OrderRepository;
import com.example.teamvoytesttask.service.OrderService;
import com.example.teamvoytesttask.service.ProductService;
import com.example.teamvoytesttask.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ShoppingCartService shoppingCartService,
                            ProductService productService) {
        this.orderRepository = orderRepository;
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setOrderTime(LocalDateTime.now());
        order.setProducts(shoppingCart.getProducts());
        order.setUser(shoppingCart.getUser());
        orderRepository.save(order);
        for (Product currentProduct : order.getProducts()) {
            productService.buy(currentProduct, currentProduct.getQuantity());
        }
        shoppingCartService.clear(shoppingCart);
        return order;
    }
}

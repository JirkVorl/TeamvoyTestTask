package com.example.teamvoytesttask.controller;

import com.example.teamvoytesttask.dto.response.OrderResponseDto;
import com.example.teamvoytesttask.dto.response.ShoppingCartResponseDto;
import com.example.teamvoytesttask.model.Order;
import com.example.teamvoytesttask.model.ShoppingCart;
import com.example.teamvoytesttask.model.User;
import com.example.teamvoytesttask.service.OrderService;
import com.example.teamvoytesttask.service.ShoppingCartService;
import com.example.teamvoytesttask.service.UserService;
import com.example.teamvoytesttask.service.mapper.ResponseMapper;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final ResponseMapper<OrderResponseDto, Order> orderMapper;


    public OrderController(OrderService orderService,
                           ShoppingCartService shoppingCartService,
                           UserService userService,
                           ResponseMapper<OrderResponseDto, Order> orderMapper) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.orderMapper = orderMapper;
    }

    @PostMapping("/complete-order")
    public OrderResponseDto completeOrder(Authentication auth) {
        String email = auth.getName();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        return orderMapper.mapToDto(orderService.completeOrder(shoppingCart));
    }
}

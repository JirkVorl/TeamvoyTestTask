package com.example.teamvoytesttask.controller;

import com.example.teamvoytesttask.dto.response.ShoppingCartResponseDto;
import com.example.teamvoytesttask.model.Product;
import com.example.teamvoytesttask.model.ShoppingCart;
import com.example.teamvoytesttask.model.User;
import com.example.teamvoytesttask.service.ProductService;
import com.example.teamvoytesttask.service.ShoppingCartService;
import com.example.teamvoytesttask.service.UserService;
import com.example.teamvoytesttask.service.mapper.ResponseMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/shopping-cart")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final ResponseMapper<ShoppingCartResponseDto, ShoppingCart> cartResponseMapper;
    private final ProductService productService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  ResponseMapper<ShoppingCartResponseDto, ShoppingCart> cartResponseMapper,
                                  ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.cartResponseMapper = cartResponseMapper;
        this.productService = productService;
    }

    @PutMapping("/products")
    public void addToCart(Authentication auth, @RequestParam Long productId) {
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        Product product = productService.getById(productId);
        shoppingCartService.addProduct(product,user);
    }
}

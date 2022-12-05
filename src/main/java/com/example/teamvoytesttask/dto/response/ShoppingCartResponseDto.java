package com.example.teamvoytesttask.dto.response;

import com.example.teamvoytesttask.model.Product;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

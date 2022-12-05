package com.example.teamvoytesttask.service;

import com.example.teamvoytesttask.model.Product;

import java.util.List;

public interface ProductService {
    Product add(Product product);

    Product buy(Product product, int quantity);

    List<Product> getAll();

    Product getById(Long id);
}

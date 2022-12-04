package com.example.teamvoytesttask.service;

import com.example.teamvoytesttask.model.Product;

public interface ProductService {
    Product add(Product product);

    Product buy(Product product, int quantity);

}

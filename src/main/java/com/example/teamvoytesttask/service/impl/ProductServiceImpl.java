package com.example.teamvoytesttask.service.impl;

import com.example.teamvoytesttask.model.Product;
import com.example.teamvoytesttask.repository.ProductRepository;
import com.example.teamvoytesttask.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product buy(Product product, int quantity) {
        Product productFromDb = productRepository.findByName(product.getName()).orElseThrow(
                () -> new RuntimeException("Can't get product by name " + product.getName()));
        productFromDb.setQuantity(product.getQuantity() - quantity);
        return productRepository.save(productFromDb);
    }
}

package com.example.teamvoytesttask.controller;

import com.example.teamvoytesttask.dto.request.ProductRequestDto;
import com.example.teamvoytesttask.dto.response.ProductResponseDto;
import com.example.teamvoytesttask.model.Product;
import com.example.teamvoytesttask.service.ProductService;
import com.example.teamvoytesttask.service.mapper.RequestMapper;
import com.example.teamvoytesttask.service.mapper.ResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ResponseMapper<ProductResponseDto, Product> productResponseMapper;
    private final RequestMapper<ProductRequestDto, Product> productRequestMapper;

    public ProductController(ProductService productService,
                             ResponseMapper<ProductResponseDto, Product> productResponseMapper,
                             RequestMapper<ProductRequestDto, Product> productRequestMapper) {
        this.productService = productService;
        this.productResponseMapper = productResponseMapper;
        this.productRequestMapper = productRequestMapper;
    }


    @GetMapping
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAll().stream()
                .map(productResponseMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public ProductResponseDto addProduct(@RequestBody ProductRequestDto productRequestDto) {
        Product product = productService.add(productRequestMapper.mapToModel(productRequestDto));
        return productResponseMapper.mapToDto(product);
    }
}

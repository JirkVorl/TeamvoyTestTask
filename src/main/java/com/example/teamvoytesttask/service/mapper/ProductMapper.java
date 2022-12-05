package com.example.teamvoytesttask.service.mapper;

import com.example.teamvoytesttask.dto.request.ProductRequestDto;
import com.example.teamvoytesttask.dto.response.ProductResponseDto;
import com.example.teamvoytesttask.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements ResponseMapper<ProductResponseDto, Product>,
        RequestMapper<ProductRequestDto, Product> {
    @Override
    public ProductResponseDto mapToDto(Product product) {
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setProductName(product.getName());
        responseDto.setPrice(product.getPrice());
        responseDto.setQuantity(product.getQuantity());
        return responseDto;
    }

    @Override
    public Product mapToModel(ProductRequestDto dto) {
        Product product = new Product();
        product.setQuantity(dto.getQuantity());
        product.setPrice(dto.getPrice());
        product.setName(dto.getProductName());
        return product;
    }
}

package com.example.teamvoytesttask.service.mapper;

import com.example.teamvoytesttask.dto.response.ProductResponseDto;
import com.example.teamvoytesttask.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements ResponseMapper<ProductResponseDto, Product> {
    @Override
    public ProductResponseDto mapToDto(Product product) {
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setProductName(product.getName());
        responseDto.setPrice(product.getPrice());
        responseDto.setQuantity(product.getQuantity());
        return responseDto;
    }
}

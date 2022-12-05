package com.example.teamvoytesttask.service.mapper;

import com.example.teamvoytesttask.dto.response.ShoppingCartResponseDto;
import com.example.teamvoytesttask.model.ShoppingCart;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper implements ResponseMapper<ShoppingCartResponseDto, ShoppingCart> {
    @Override
    public ShoppingCartResponseDto mapToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setId(shoppingCart.getId());
        responseDto.setProducts(shoppingCart.getProducts());
        return responseDto;
    }
}

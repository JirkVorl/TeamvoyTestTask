package com.example.teamvoytesttask.service.mapper;

import com.example.teamvoytesttask.dto.response.OrderResponseDto;
import com.example.teamvoytesttask.model.Order;
import com.example.teamvoytesttask.model.Product;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class OrderMapper implements ResponseMapper<OrderResponseDto, Order> {

    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setOrderTime(order.getOrderTime());
        responseDto.setUserId(order.getUser().getId());
        responseDto.setProductIds(order.getProducts().stream()
                .map(Product::getId)
                .collect(Collectors.toList()));
        return responseDto;
    }
}

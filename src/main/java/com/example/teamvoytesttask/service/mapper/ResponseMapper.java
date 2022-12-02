package com.example.teamvoytesttask.service.mapper;

public interface ResponseMapper<D, T> {
    D mapToDto(T t);
}

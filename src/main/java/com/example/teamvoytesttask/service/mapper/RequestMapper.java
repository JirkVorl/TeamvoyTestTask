package com.example.teamvoytesttask.service.mapper;

public interface RequestMapper <D, T> {
    T mapToModel(D dto);
}

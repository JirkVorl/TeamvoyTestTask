package com.example.teamvoytesttask.repository;

import com.example.teamvoytesttask.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long id);

    Optional<Product> findByName(String name);

    List<Product> findAll();

}

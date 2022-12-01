package com.example.teamvoytesttask.repository;

import com.example.teamvoytesttask.model.ShoppingCart;
import com.example.teamvoytesttask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    Optional<ShoppingCart> findByUser(User user);

    ShoppingCart update(ShoppingCart shoppingCart);

}

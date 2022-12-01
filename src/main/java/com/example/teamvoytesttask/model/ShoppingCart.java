package com.example.teamvoytesttask.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private User user;
    @OneToMany
    @JoinTable(name = "shopping_carts_products",
                joinColumns = @JoinColumn(name = "shopping_cart_id"),
                inverseJoinColumns = @JoinColumn(name = "ticket_id"))
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ShoppingCart{"
                + "id=" + id
                + ", user=" + user
                + ", products=" + products + '}';
    }
}

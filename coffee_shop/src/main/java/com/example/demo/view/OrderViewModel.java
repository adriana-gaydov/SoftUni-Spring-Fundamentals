package com.example.demo.view;

import java.math.BigDecimal;

public class OrderViewModel {

    private Long id;
    private String name;

    private BigDecimal price;

    private String category;

    public OrderViewModel() {
    }

    public String getName() {
        return name;
    }

    public OrderViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public OrderViewModel setCategory(String category) {
        this.category = category;
        return this;
    }

    public Long getId() {
        return id;
    }

    public OrderViewModel setId(Long id) {
        this.id = id;
        return this;
    }
}

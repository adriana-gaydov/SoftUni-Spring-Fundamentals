package com.example.demo.view;

public class UserViewModel {

    private String username;

    private int ordersCount;

    public UserViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public int getOrdersCount() {
        return ordersCount;
    }

    public UserViewModel setOrdersCount(int ordersCount) {
        this.ordersCount = ordersCount;
        return this;
    }
}

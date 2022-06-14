package com.example.demo.service;

import com.example.demo.service.model.OrderServiceModel;
import com.example.demo.view.OrderViewModel;

import java.util.List;

public interface OrderService {

    OrderServiceModel addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllByPriceDesc();

    int getNeededTime();

    void readyOrder(Long id);
}

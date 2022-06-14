package com.example.demo.service.impl;

import com.example.demo.model.entity.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.security.CurrentUser;
import com.example.demo.service.CategoryService;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import com.example.demo.service.model.OrderServiceModel;
import com.example.demo.view.OrderViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private CategoryService categoryService;
    private UserService userService;
    private ModelMapper modelMapper;
    private CurrentUser currentUser;


    public OrderServiceImpl(OrderRepository orderRepository, CategoryService categoryService, UserService userService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.orderRepository = orderRepository;
        this.categoryService = categoryService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public OrderServiceModel addOrder(OrderServiceModel orderServiceModel) {

        Order order = this.modelMapper.map(orderServiceModel, Order.class);

        //get category
        order.setCategory(this.categoryService.findByCategoryNameEnum(orderServiceModel.getCategory()));

        //get currentUser
        order.setEmployee(this.userService.findById(currentUser.getId()));

        this.orderRepository.save(order);

        return orderServiceModel;
    }

    @Override
    public List<OrderViewModel> findAllByPriceDesc() {

        return  this.orderRepository.findAllByOrderByPriceDesc()
                .stream()
                .map(this::createView)
                .collect(Collectors.toList());
    }

    @Override
    public int getNeededTime() {

        return this.orderRepository.findAll()
                .stream().mapToInt(e -> e.getCategory().getNeededTime())
                .sum();

    }

    @Override
    public void readyOrder(Long id) {

        this.orderRepository.deleteById(id);
    }

    private OrderViewModel createView(Order e) {

        OrderViewModel view = new OrderViewModel();
        view.setName(e.getName());
        view.setPrice(e.getPrice());
        view.setId(e.getId());
        view.setCategory(e.getCategory().getName().name().toLowerCase());

        return view;
    }
}

package com.example.demo.service;

import com.example.demo.model.entity.User;
import com.example.demo.service.model.UserServiceModel;
import com.example.demo.view.UserViewModel;

import java.util.List;

public interface UserService {

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(UserServiceModel userServiceModel);

    UserServiceModel loginUser(UserServiceModel userServiceModel);

    User findById(Long id);

    List<UserViewModel> findAllByCountOfOrdersDesc();
}

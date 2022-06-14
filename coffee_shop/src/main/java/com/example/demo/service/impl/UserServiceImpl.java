package com.example.demo.service.impl;

import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.CurrentUser;
import com.example.demo.service.UserService;
import com.example.demo.service.model.UserServiceModel;
import com.example.demo.view.UserViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    private CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        User user = this.modelMapper.map(userServiceModel, User.class);

        return this.modelMapper.map(this.userRepository.save(user), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(UserServiceModel userServiceModel) {

        return this.userRepository.findByUsernameAndPassword(userServiceModel.getUsername(), userServiceModel.getPassword())
                .map(u -> modelMapper.map(u, UserServiceModel.class))
                .orElse(null);

    }

    @Override
    public UserServiceModel loginUser(UserServiceModel userServiceModel) {

        this.currentUser.setId(userServiceModel.getId());
        this.currentUser.setUsername(userServiceModel.getUsername());

        return userServiceModel;
    }

    @Override
    public User findById(Long id) {

        return this.userRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<UserViewModel> findAllByCountOfOrdersDesc() {

        return this.userRepository.findAllOrderByOrdersDesc()
                .stream()
                .map(this::createView)
                .collect(Collectors.toList());

    }

    private UserViewModel createView(User e) {
        UserViewModel view = new UserViewModel();
        view.setUsername(e.getUsername());
        view.setOrdersCount(e.getOrders().size());

        return view;
    }
}

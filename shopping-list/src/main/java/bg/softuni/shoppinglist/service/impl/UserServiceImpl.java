package bg.softuni.shoppinglist.service.impl;

import bg.softuni.shoppinglist.model.entity.User;
import bg.softuni.shoppinglist.model.service.UserServiceModel;
import bg.softuni.shoppinglist.repository.UserRepository;
import bg.softuni.shoppinglist.security.CurrentUser;
import bg.softuni.shoppinglist.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
    public UserServiceModel register(UserServiceModel userServiceModel) {

        User user = this.modelMapper.map(userServiceModel, User.class);

        return this.modelMapper.map(this.userRepository.save(user), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {

        return this.userRepository.findByUsernameAndPassword(username, password)
                .map(u -> modelMapper.map(u, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public UserServiceModel login(UserServiceModel userServiceModel) {

        this.currentUser.setUsername(userServiceModel.getUsername());
        this.currentUser.setId(userServiceModel.getId());

        return userServiceModel;
    }

}

package bg.softuni.battleship.service.impl;

import bg.softuni.battleship.model.entity.User;
import bg.softuni.battleship.repository.UserRepository;
import bg.softuni.battleship.security.CurrentUser;
import bg.softuni.battleship.service.UserService;
import bg.softuni.battleship.service.model.UserServiceModel;
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
    public boolean existsByEmail(String email) {

        return this.userRepository.findByEmail(email).isPresent();
    }

    @Override
    public boolean existsByUsername(String username) {

        return this.userRepository.findByUsername(username).isPresent();
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

        this.currentUser.setId(userServiceModel.getId());
        this.currentUser.setUsername(userServiceModel.getUsername());

        return userServiceModel;
    }

    @Override
    public User findById(Long id) {

        return this.userRepository.findById(id)
                .orElse(null);
    }
}

package bg.softuni.battleship.service;

import bg.softuni.battleship.model.entity.User;
import bg.softuni.battleship.service.model.UserServiceModel;

public interface UserService {
    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    UserServiceModel register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    UserServiceModel login(UserServiceModel userServiceModel);

    User findById(Long id);
}

package bg.softuni.shoppinglist.service;

import bg.softuni.shoppinglist.model.service.UserServiceModel;

public interface UserService {

    UserServiceModel register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    UserServiceModel login(UserServiceModel userServiceModel);
}

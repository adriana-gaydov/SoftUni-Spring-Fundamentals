package bg.softuni.pathfinder.services;

import bg.softuni.pathfinder.models.Role;
import bg.softuni.pathfinder.models.enums.LevelEnum;
import bg.softuni.pathfinder.models.enums.RoleEnum;
import bg.softuni.pathfinder.models.users.CurrentUser;
import bg.softuni.pathfinder.models.users.User;
import bg.softuni.pathfinder.models.users.UserLoginDTO;
import bg.softuni.pathfinder.models.users.UserRegistrationDTO;
import bg.softuni.pathfinder.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    private CurrentUser currentUser;
    private PasswordEncoder passwordEncoder;
   // private Logger LOGGER;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        //this.LOGGER = LoggerFactory.getLogger(UserService.class);
    }

    public void registerAndLogin(UserRegistrationDTO userModel) {

        User user = modelMapper.map(userModel, User.class)
                .setPassword(passwordEncoder.encode(userModel.getPassword()))
                .setLevel(LevelEnum.BEGINNER)
                .setRoles(List.of(new Role().setName(RoleEnum.USER)));

        userRepository.save(user);

        this.currentUser = new CurrentUser(user.getFullName(), true);
    }

    public void logout() {
        this.currentUser = null;
    }

    public boolean login(UserLoginDTO userModel) {
        Optional<User> optUser = userRepository.findByUsername(userModel.getUsername());

        if (optUser.isEmpty()) {
            //LOGGER.info("Username not found!");

            return false;
        }

        User user = optUser.get();

        String rawPass = userModel.getPassword();
        String encPass = passwordEncoder.encode(rawPass);

        if (!user.getPassword().equals(encPass)) {
            //LOGGER.info("Invalid password!");

            return false;
        }

        login(user);
        return true;
    }

    private void login(User user) {
        this.currentUser.setLogged(true)
                .setName(user.getFullName())
                .setAdmin(isAdmin(user));
    }

    private boolean isAdmin(User user) {
        return user.getRoles().stream().map(Role::getName).anyMatch(e -> e == RoleEnum.ADMIN);
    }
}

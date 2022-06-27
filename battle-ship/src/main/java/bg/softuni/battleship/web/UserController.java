package bg.softuni.battleship.web;

import bg.softuni.battleship.model.binding.UserLoginBindingModel;
import bg.softuni.battleship.model.binding.UserRegisterBindingModel;
import bg.softuni.battleship.security.CurrentUser;
import bg.softuni.battleship.service.UserService;
import bg.softuni.battleship.service.model.UserServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private ModelMapper modelMapper;
    private CurrentUser currentUser;

    public UserController(UserService userService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @GetMapping("/register")
    public String register() {

        if (currentUser.isLoggedIn()) {
            return "redirect:/home";
        }

        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {


        boolean passwordsMatch = userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword());

        if (bindingResult.hasErrors()) {

            if (!passwordsMatch) {
                bindingResult.addError(new FieldError("confirmPassword", "confirmPassword", "Passwords must be the same."));
            }

            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:register";
        }

        this.userService.register(this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class));

        return "redirect:login";

    }

    @GetMapping("/login")
    public String login() {

        if (currentUser.isLoggedIn()) {
            return "redirect:/home";
        }

        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        //invalid obj
        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

            return "redirect:login";
        }

        //not existing
        UserServiceModel userServiceModel = this.userService.findByUsernameAndPassword(
                userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword());

        if (userServiceModel == null) {

            redirectAttributes.addFlashAttribute("notFound", true);
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);

            return "redirect:login";
        }

        //login
        this.userService.login(userServiceModel);

        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {

        httpSession.invalidate();

        return "redirect:/";
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }
}

package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.models.users.UserLoginDTO;
import bg.softuni.pathfinder.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userModel")
    public UserLoginDTO initUserModel() {
        return new UserLoginDTO();
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(UserLoginDTO userModel) {

//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("userModel", userModel);
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
//
//            return "redirect:/login";
//        }

        userService.login(userModel);

        return "redirect:home";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:home";
    }
}

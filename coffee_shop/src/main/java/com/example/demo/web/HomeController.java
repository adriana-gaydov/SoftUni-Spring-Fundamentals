package com.example.demo.web;

import com.example.demo.security.CurrentUser;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private CurrentUser currentUser;
    private OrderService orderService;
    private UserService userService;

    public HomeController(CurrentUser currentUser, OrderService orderService, UserService userService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }


        model.addAttribute("orders", this.orderService.findAllByPriceDesc());

        model.addAttribute("employees", this.userService.findAllByCountOfOrdersDesc());

        model.addAttribute("neededTime", this.orderService.getNeededTime());

        return "home";
    }

}

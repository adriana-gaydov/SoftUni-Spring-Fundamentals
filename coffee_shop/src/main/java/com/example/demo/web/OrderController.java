package com.example.demo.web;

import com.example.demo.model.binding.OrderAddBindingModel;
import com.example.demo.service.OrderService;
import com.example.demo.service.model.OrderServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;
    private ModelMapper modelMapper;

    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addOrder() {
        return "order-add";
    }

    @PostMapping("/add")
    public String addOrder(@Valid OrderAddBindingModel orderAddBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("orderAddBindingModel", orderAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.orderAddBindingModel", bindingResult);

            return "redirect:add";
        }

        //todo:: save order
        this.orderService.addOrder(this.modelMapper.map(orderAddBindingModel, OrderServiceModel.class));

        return "redirect:/";
    }


    @GetMapping("/ready/{id}")
    public String readyOrder(@PathVariable Long id) {

        this.orderService.readyOrder(id);

        return "redirect:/";
    }
    @ModelAttribute("orderAddBindingModel")
    public OrderAddBindingModel orderAddBindingModel() {
        return new OrderAddBindingModel();
    }

}

package bg.softuni.shoppinglist.web;

import bg.softuni.shoppinglist.model.enums.CategoryNameEnum;
import bg.softuni.shoppinglist.security.CurrentUser;
import bg.softuni.shoppinglist.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    private CurrentUser currentUser;

    private ProductService productService;

    public HomeController(CurrentUser currentUser, ProductService productService) {
        this.currentUser = currentUser;
        this.productService = productService;
    }


    @GetMapping("/")
    public String index(Model model) {

        if (currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("foods", this.productService.findByCategoryNameEnum(CategoryNameEnum.Food));
        model.addAttribute("drinks", this.productService.findByCategoryNameEnum(CategoryNameEnum.Drink));
        model.addAttribute("households", this.productService.findByCategoryNameEnum(CategoryNameEnum.Household));
        model.addAttribute("others", this.productService.findByCategoryNameEnum(CategoryNameEnum.Other));
        model.addAttribute("totalPrice", this.productService.getTotalPriceOfProducts());

        return "home";
    }

}

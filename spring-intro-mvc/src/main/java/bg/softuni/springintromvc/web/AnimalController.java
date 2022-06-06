package bg.softuni.springintromvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnimalController {

    @GetMapping("/cat")
    public String cat() {
        return "cat-page";
    }

    @GetMapping("/dog-page")
    public String dog(Model model, @RequestParam("dogName") String dogName) {
        model.addAttribute("dogName", dogName);

        return "redirect:/dog-page-result";
    }


}

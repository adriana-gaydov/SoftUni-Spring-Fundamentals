package bg.softuni.springintromvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NameController {

    @GetMapping("/name")
    public String name(@RequestParam(name = "name", required = false, defaultValue = "Anon") String name, Model model) {

        model.addAttribute("name", name);
        return "name";
    }

    @GetMapping("/name/{id}")
    public String name(@PathVariable(name = "id") Long id, @RequestParam(name = "name", required = false, defaultValue = "Anon") String name, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "name";
    }
}

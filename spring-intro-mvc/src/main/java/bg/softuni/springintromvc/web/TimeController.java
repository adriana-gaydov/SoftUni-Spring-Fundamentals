package bg.softuni.springintromvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/time")
public class TimeController {

    @GetMapping("")
    public String time(Model model) {
        model.addAttribute("currentTime", LocalDateTime.now());

        return "current-time";
    }
}

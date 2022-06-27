package bg.softuni.battleship.web;

import bg.softuni.battleship.model.view.ShipViewModel;
import bg.softuni.battleship.security.CurrentUser;
import bg.softuni.battleship.service.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Controller
public class HomeController {

    private CurrentUser currentUser;
    private ShipService shipService;

    public HomeController(CurrentUser currentUser, ShipService shipService) {
        this.currentUser = currentUser;
        this.shipService = shipService;
    }

    @GetMapping("/")
    public String index() {

        if (this.currentUser.isLoggedIn()) {
            return "redirect:/home";
        }

        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {

        if (!this.currentUser.isLoggedIn()) {

            return "redirect:/";
        }

        List<ShipViewModel> ships = this.shipService.getAllShips();

        List<ShipViewModel> curUserShips = ships.stream().filter(e -> Objects.equals(e.getUser().getId(), this.currentUser.getId())).toList();
        List<ShipViewModel> otherUsersShips = ships.stream().filter(e -> !Objects.equals(e.getUser().getId(), this.currentUser.getId())).toList();

        model.addAttribute("allShips", ships);
        model.addAttribute("curUserShips", curUserShips);
        model.addAttribute("otherUsersShips", otherUsersShips);

        return "home";
    }
}

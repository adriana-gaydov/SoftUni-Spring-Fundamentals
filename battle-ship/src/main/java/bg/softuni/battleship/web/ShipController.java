package bg.softuni.battleship.web;

import bg.softuni.battleship.model.binding.ShipAddBindingModel;
import bg.softuni.battleship.security.CurrentUser;
import bg.softuni.battleship.service.ShipService;
import bg.softuni.battleship.service.model.ShipServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/ships")
public class ShipController {

    private ShipService shipService;
    private ModelMapper modelMapper;
    private CurrentUser currentUser;

    public ShipController(ShipService shipService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.shipService = shipService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @GetMapping("/add")
    public String addShip() {

        if (!currentUser.isLoggedIn()) {
            return "redirect:/";
        }

        return "ship-add";
    }


    @PostMapping("/add")
    public String addShip(@Valid ShipAddBindingModel shipAddBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("shipAddBindingModel", shipAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel", bindingResult);

            return "redirect:add";
        }

        this.shipService.addShip(this.modelMapper.map(shipAddBindingModel, ShipServiceModel.class));


        return "redirect:/home";
    }


    @ModelAttribute
    public ShipAddBindingModel shipAddBindingModel() {

        return new ShipAddBindingModel();
    }
}

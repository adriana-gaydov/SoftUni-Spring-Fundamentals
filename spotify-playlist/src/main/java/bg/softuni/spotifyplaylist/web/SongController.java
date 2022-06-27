package bg.softuni.spotifyplaylist.web;

import bg.softuni.spotifyplaylist.model.binding.SongAddBindingModel;
import bg.softuni.spotifyplaylist.model.service.SongServiceModel;
import bg.softuni.spotifyplaylist.security.CurrentUser;
import bg.softuni.spotifyplaylist.service.SongService;
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
@RequestMapping("/songs")
public class SongController {

    private final CurrentUser currentUser;
    private final SongService songService;
    private final ModelMapper modelMapper;

    public SongController(CurrentUser currentUser, SongService songService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.songService = songService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addSong() {

        if (!this.currentUser.isLoggedIn()) {
            return "redirect:/";
        }

        return "song-add";
    }

    @PostMapping("/add")
    public String addSong(@Valid SongAddBindingModel songAddBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("songAddBindingModel", songAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.songAddBindingModel", bindingResult);

            return "redirect:add";
        }

        //save
        this.songService.addSong(this.modelMapper.map(songAddBindingModel, SongServiceModel.class));

        return "redirect:/home";
    }

    @ModelAttribute
    public SongAddBindingModel songAddBindingModel() {
        return new SongAddBindingModel();
    }
}

package bg.softuni.spotifyplaylist.web;

import bg.softuni.spotifyplaylist.model.enums.StyleNameEnum;
import bg.softuni.spotifyplaylist.model.view.SongViewModel;
import bg.softuni.spotifyplaylist.security.CurrentUser;
import bg.softuni.spotifyplaylist.service.SongService;
import bg.softuni.spotifyplaylist.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final SongService songService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, SongService songService, UserService userService) {
        this.currentUser = currentUser;
        this.songService = songService;
        this.userService = userService;
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

        List<SongViewModel> popSongs = this.songService.findByStyle(StyleNameEnum.Pop);
        List<SongViewModel> rockSongs = this.songService.findByStyle(StyleNameEnum.Rock);
        List<SongViewModel> jazzSongs = this.songService.findByStyle(StyleNameEnum.Jazz);

        model.addAttribute("popSongs", popSongs);
        model.addAttribute("rockSongs", rockSongs);
        model.addAttribute("jazzSongs", jazzSongs);

        List<SongViewModel> userPlaylist = this.userService.getPlaylistById(currentUser.getId());
        model.addAttribute("userPlaylist", userPlaylist);

        int totalTimeSec = getPlaylistTotalTime(userPlaylist);
        model.addAttribute("totalTime", String.format("%d:%02d", totalTimeSec / 60, totalTimeSec % 60));

        return "home";
    }

    private int getPlaylistTotalTime(List<SongViewModel> userPlaylist) {
        return userPlaylist.stream().mapToInt(SongViewModel::getDuration)
                .sum();
    }
}

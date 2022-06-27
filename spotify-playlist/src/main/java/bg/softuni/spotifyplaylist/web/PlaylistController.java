package bg.softuni.spotifyplaylist.web;

import bg.softuni.spotifyplaylist.model.entity.Song;
import bg.softuni.spotifyplaylist.model.entity.User;
import bg.softuni.spotifyplaylist.model.view.SongViewModel;
import bg.softuni.spotifyplaylist.security.CurrentUser;
import bg.softuni.spotifyplaylist.service.SongService;
import bg.softuni.spotifyplaylist.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/playlist")
public class PlaylistController {

    private final CurrentUser currentUser;
    private final UserService userService;
    private final SongService songService;

    public PlaylistController(CurrentUser currentUser, UserService userService, SongService songService) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.songService = songService;
    }

    @GetMapping("/remove/id/{id}")
    public String removeSongById(@PathVariable Long id) {

        if (!currentUser.isLoggedIn()) {
            return "redirect:/";
        }

        Song song = this.songService.findById(id);
        this.userService.removeSong(song);

        return "redirect:/home";
    }

    @GetMapping("/remove")
    public String removeSongs() {

        if (!currentUser.isLoggedIn()) {
            return "redirect:/";
        }

        this.userService.removeAllSongs();

        return "redirect:/";
    }

    @GetMapping("/add/id/{id}")
    public String addSong(@PathVariable Long id) {

        if (!currentUser.isLoggedIn()) {
            return "redirect:/";
        }

        Song song = this.songService.findById(id);
        this.userService.addSong(song);

        return "redirect:/";
    }
}

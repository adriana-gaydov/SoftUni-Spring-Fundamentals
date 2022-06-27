package bg.softuni.spotifyplaylist.service;

import bg.softuni.spotifyplaylist.model.entity.Song;
import bg.softuni.spotifyplaylist.model.entity.User;
import bg.softuni.spotifyplaylist.model.service.UserServiceModel;
import bg.softuni.spotifyplaylist.model.view.SongViewModel;

import java.util.List;

public interface UserService {
    UserServiceModel register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    UserServiceModel login(UserServiceModel userServiceModel);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    void addSong(Song song);

    List<SongViewModel> getPlaylistById(Long id);

    User findById(Long id);

    void removeSong(Song song);

    void removeAllSongs();
}

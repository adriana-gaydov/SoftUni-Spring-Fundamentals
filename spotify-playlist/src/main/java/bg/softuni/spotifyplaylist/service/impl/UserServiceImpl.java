package bg.softuni.spotifyplaylist.service.impl;

import bg.softuni.spotifyplaylist.model.entity.Song;
import bg.softuni.spotifyplaylist.model.entity.User;
import bg.softuni.spotifyplaylist.model.service.UserServiceModel;
import bg.softuni.spotifyplaylist.model.view.SongViewModel;
import bg.softuni.spotifyplaylist.repository.UserRepository;
import bg.softuni.spotifyplaylist.security.CurrentUser;
import bg.softuni.spotifyplaylist.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel register(UserServiceModel userServiceModel) {

        User user = this.modelMapper.map(userServiceModel, User.class);

        return this.modelMapper.map(this.userRepository.save(user), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {

       return  this.userRepository.findByUsernameAndPassword(username, password)
               .map(u -> this.modelMapper.map(u, UserServiceModel.class))
               .orElse(null);
    }

    @Override
    public UserServiceModel login(UserServiceModel userServiceModel) {

        this.currentUser.setId(userServiceModel.getId());
        this.currentUser.setUsername(userServiceModel.getUsername());

        return userServiceModel;
    }

    @Override
    public boolean existsByUsername(String username) {

        return this.userRepository.findByUsername(username).isPresent();
    }

    @Override
    public boolean existsByEmail(String email) {

        return this.userRepository.findByEmail(email).isPresent();
    }

    @Override
    public void addSong(Song song) {

        User user = this.userRepository.findById(this.currentUser.getId()).get();

        user.addSong(song);

        this.userRepository.save(user);
    }

    @Override
    public List<SongViewModel> getPlaylistById(Long id) {

        User user = this.userRepository.getById(id);

        return user.getPlaylist().stream()
                .map(s -> this.modelMapper.map(s, SongViewModel.class))
                .toList();
    }

    @Override
    public User findById(Long id) {

        return this.userRepository.getById(id);
    }

    @Override
    public void removeSong(Song song) {

        User curUser = findById(currentUser.getId());
        curUser.removeSong(song);

        this.userRepository.save(curUser);
    }

    @Override
    public void removeAllSongs() {

        User curUser = findById(currentUser.getId());
        curUser.removeAllSongs();

        this.userRepository.save(curUser);
    }
}

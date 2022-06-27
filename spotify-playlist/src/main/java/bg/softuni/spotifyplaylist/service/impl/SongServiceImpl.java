package bg.softuni.spotifyplaylist.service.impl;

import bg.softuni.spotifyplaylist.model.entity.Song;
import bg.softuni.spotifyplaylist.model.entity.Style;
import bg.softuni.spotifyplaylist.model.enums.StyleNameEnum;
import bg.softuni.spotifyplaylist.model.service.SongServiceModel;
import bg.softuni.spotifyplaylist.model.view.SongViewModel;
import bg.softuni.spotifyplaylist.repository.SongRepository;
import bg.softuni.spotifyplaylist.service.SongService;
import bg.softuni.spotifyplaylist.service.StyleService;
import bg.softuni.spotifyplaylist.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final ModelMapper modelMapper;
    private final StyleService styleService;
    private final UserService userService;

    public SongServiceImpl(SongRepository songRepository, ModelMapper modelMapper, StyleService styleService, UserService userService) {
        this.songRepository = songRepository;
        this.modelMapper = modelMapper;
        this.styleService = styleService;
        this.userService = userService;
    }

    @Override
    public boolean existsByPerformerName(String performerName) {

        return this.songRepository.findByPerformer(performerName).isPresent();
    }

    @Override
    public SongServiceModel addSong(SongServiceModel songServiceModel) {

        Song song = this.modelMapper.map(songServiceModel, Song.class);

        Style style = this.styleService.findByStyleNameEnum(songServiceModel.getStyle());
        song.setStyle(style);

        this.songRepository.save(song);
//        song = this.songRepository.save(song);
//        this.userService.addSong(song);

        return songServiceModel;
    }

    @Override
    public List<SongViewModel> findByStyle(StyleNameEnum styleNameEnum) {

        return this.songRepository.findAllByStyleName(styleNameEnum)
                .stream()
                .map(e -> this.modelMapper.map(e, SongViewModel.class))
                .toList();
    }

    @Override
    public Song findById(Long id) {

        return this.songRepository.getById(id);
    }

}

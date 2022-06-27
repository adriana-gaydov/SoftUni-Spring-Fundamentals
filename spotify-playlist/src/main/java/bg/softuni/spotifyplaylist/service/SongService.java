package bg.softuni.spotifyplaylist.service;

import bg.softuni.spotifyplaylist.model.entity.Song;
import bg.softuni.spotifyplaylist.model.enums.StyleNameEnum;
import bg.softuni.spotifyplaylist.model.service.SongServiceModel;
import bg.softuni.spotifyplaylist.model.view.SongViewModel;

import java.util.List;

public interface SongService {


    boolean existsByPerformerName(String performerName);

    SongServiceModel addSong(SongServiceModel songServiceModel);

    List<SongViewModel> findByStyle(StyleNameEnum styleNameEnum);

    Song findById(Long id);
}

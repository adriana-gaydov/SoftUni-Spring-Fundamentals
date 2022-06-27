package bg.softuni.spotifyplaylist.service;

import bg.softuni.spotifyplaylist.model.entity.Style;
import bg.softuni.spotifyplaylist.model.enums.StyleNameEnum;

public interface StyleService {

    void initStyles();

    Style findByStyleNameEnum(StyleNameEnum style);
}

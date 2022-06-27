package bg.softuni.spotifyplaylist.service.impl;

import bg.softuni.spotifyplaylist.model.entity.Style;
import bg.softuni.spotifyplaylist.model.enums.StyleNameEnum;
import bg.softuni.spotifyplaylist.repository.StyleRepository;
import bg.softuni.spotifyplaylist.service.StyleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StyleServiceImpl implements StyleService {

    private final StyleRepository styleRepository;

    public StyleServiceImpl(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public void initStyles() {

        if (this.styleRepository.count() != 0) {
            return;
        }

        List<Style> styles = Arrays.stream(StyleNameEnum.values())
                .map(s -> new Style()
                        .setName(s)
                        .setDescription(s + " description..."))
                .toList();

        this.styleRepository.saveAll(styles);
    }

    @Override
    public Style findByStyleNameEnum(StyleNameEnum style) {

        return this.styleRepository.findByName(style)
                .orElse(null);
    }
}

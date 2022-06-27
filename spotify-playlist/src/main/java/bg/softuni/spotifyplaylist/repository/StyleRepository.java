package bg.softuni.spotifyplaylist.repository;

import bg.softuni.spotifyplaylist.model.entity.Style;
import bg.softuni.spotifyplaylist.model.enums.StyleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long> {
    Optional<Style> findByName(StyleNameEnum style);
}

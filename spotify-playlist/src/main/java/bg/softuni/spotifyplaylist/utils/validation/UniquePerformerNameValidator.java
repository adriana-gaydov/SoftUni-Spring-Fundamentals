package bg.softuni.spotifyplaylist.utils.validation;

import bg.softuni.spotifyplaylist.service.SongService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquePerformerNameValidator implements ConstraintValidator<UniquePerformerName, String> {

    private final SongService songService;

    public UniquePerformerNameValidator(SongService songService) {
        this.songService = songService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        boolean isInSize = isInSize(value);

        if (!isInSize) {
            return true;
        }

        return !this.songService.existsByPerformerName(value);
    }

    private boolean isInSize(String value) {
        return value != null && value.length() >= 3 && value.length() <= 20;
    }
}

package bg.softuni.spotifyplaylist.utils.validation;

import bg.softuni.spotifyplaylist.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserService userService;

    public UniqueUsernameValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        boolean isInSize = isInSize(value);

        if (!isInSize) {
            return true;
        }

        return !this.userService.existsByUsername(value);
    }

    private boolean isInSize(String value) {
        return value != null && value.length() >= 3 && value.length() <= 20;
    }
}
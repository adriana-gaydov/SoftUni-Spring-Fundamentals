package bg.softuni.battleship.validation;

import bg.softuni.battleship.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserService userService;

    public UniqueEmailValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        boolean isInSize = isInSize(value);

        if (!isInSize) {
            return true;
        }

        return !this.userService.existsByEmail(value);
    }

    private boolean isInSize(String value) {
        return value != null && value.length() > 0;
    }
}

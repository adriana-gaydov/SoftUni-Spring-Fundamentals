package bg.softuni.battleship.validation;

import bg.softuni.battleship.service.ShipService;

import javax.validation.ConstraintValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueShipNameValidator implements ConstraintValidator<UniqueShipName, String> {

    private final ShipService shipService;

    public UniqueShipNameValidator(ShipService shipService) {
        this.shipService = shipService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        boolean isInSize = isInSize(value);

        if (!isInSize) {
            return true;
        }

        return !this.shipService.existsByShipName(value);
    }

    private boolean isInSize(String value) {
        return value != null && value.length() >= 3 && value.length() <= 10;
    }
}

package bg.softuni.spotifyplaylist.utils.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniquePerformerNameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniquePerformerName {
    String message() default "Performer name already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

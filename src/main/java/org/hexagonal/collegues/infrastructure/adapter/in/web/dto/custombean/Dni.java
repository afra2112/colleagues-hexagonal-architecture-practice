package org.hexagonal.collegues.infrastructure.adapter.in.web.dto.custombean;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
@Pattern(
        regexp = "^DNI-\\d{1,10}$"
)
public @interface Dni {

    String message() default "DNI Must not be blank and must be like: \"DNI-1234567890\"";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

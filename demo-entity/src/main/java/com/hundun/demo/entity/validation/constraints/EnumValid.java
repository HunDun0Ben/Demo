package com.hundun.demo.entity.validation.constraints;


import com.hundun.demo.entity.validation.validators.EnumValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Ben.Guo
 */
@Documented
@Target({ ElementType.PARAMETER, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { EnumValidator.class })
public @interface EnumValid {

    String message() default "The current field can't be this value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    // target class that extend Enum.
    Class<? extends Enum<?>> target();

    // validate value can be null
    boolean ignoreEmpty() default true;
}

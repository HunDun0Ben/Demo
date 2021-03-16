package com.example.demo.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TestValidator.class)
public @interface Test {

    String message() default "Test is haowan";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

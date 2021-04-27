package com.example.demo.validation.constraints;

import com.example.demo.validation.validators.TestValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TestValidator.class)
public @interface MyTeset {

    String message() default "MyTeset is haowan";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

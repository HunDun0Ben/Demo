package com.hundun.demo.entity.validation.constraints;

import com.hundun.demo.entity.validation.validators.TestValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Ben
 */
@Documented
@Target({ ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TestValidator.class)
public @interface MyTest {
    String message() default "MyTest is test validation.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

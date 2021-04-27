package com.example.demo.validation.validators;

import com.example.demo.validation.constraints.MyTeset;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class TestValidator implements ConstraintValidator<MyTeset, Object> {

    @Override
    public void initialize(MyTeset constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String str = context.getDefaultConstraintMessageTemplate();
        log.error("Default Message : {}", str);
        context.disableDefaultConstraintViolation();

        context.buildConstraintViolationWithTemplate("this is another message Tempalte").addConstraintViolation();
        return false;
    }
}

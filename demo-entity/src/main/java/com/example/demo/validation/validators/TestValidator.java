package com.example.demo.validation.validators;

import com.example.demo.validation.constraints.MyTest;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class TestValidator implements ConstraintValidator<MyTest, Object> {

    @Override
    public void initialize(MyTest constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (1 == 1)
        {return true;}
        String str = context.getDefaultConstraintMessageTemplate();
        log.error("Default Message : {}", str);
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("this is another message template").addConstraintViolation();
        return false;
    }
}

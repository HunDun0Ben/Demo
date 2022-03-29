package com.hundun.demo.entity.validation.validators;

import com.hundun.demo.entity.validation.EnumEqual;
import com.hundun.demo.entity.validation.constraints.EnumValid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class EnumValidator implements ConstraintValidator<EnumValid, Object> {

    // 枚举校验注解
    private EnumValid annotation;

    @Override
    public void initialize(EnumValid constraintAnnotation) {
        annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        boolean result = false;
        Class<?> cls = annotation.target();
        boolean ignoreEmpty = annotation.ignoreEmpty();
        // target为枚举，并且value有值，或者不忽视空值，才进行校验
        if (cls.isEnum() && (!ObjectUtils.isEmpty(value) || !ignoreEmpty)) {
            Object[] objects = cls.getEnumConstants();
            for (Object o : objects) {
                if (o instanceof EnumEqual) {
                    if (value.equals(((EnumEqual) o).getEqualObject())) {
                        result = true;
                        break;
                    }
                } else {
                    log.warn(cls.getName() + " can't use EnumValidator validate.");
                    break;
                }
            }
        } else {
            result = true;
        }
        return result;
    }
}

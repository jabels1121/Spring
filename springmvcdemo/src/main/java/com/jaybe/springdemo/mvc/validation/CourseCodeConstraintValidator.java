package com.jaybe.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
        implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        coursePrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String userInput,
                           ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if (userInput != null) {
            result = userInput.startsWith(coursePrefix);
        } else {
            return true;
        }
       return result;
    }
}

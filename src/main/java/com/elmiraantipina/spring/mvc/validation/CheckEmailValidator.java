package com.elmiraantipina.spring.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckEmailValidator implements ConstraintValidator<CheckEmail, String> {
    //указываем дженерики: CheckEmail сама аннотация, и тип данных, которым будем применять аннотацию

    private String endOfEmail;

    @Override
    public void initialize(CheckEmail checkEmail) {
        endOfEmail = checkEmail.value();//получаем конец email

    }

    @Override
    public boolean isValid(String enteredValue, ConstraintValidatorContext constraintValidatorContext) {
        //enteredValue - это значение, которое вводится в нашу форму email

        return enteredValue.endsWith(endOfEmail);//проверяем, проходит валидация или нет,
        // то есть проверяем окончание ввденного email
    }
}

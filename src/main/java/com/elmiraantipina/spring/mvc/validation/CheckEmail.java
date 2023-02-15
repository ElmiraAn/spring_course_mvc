package com.elmiraantipina.spring.mvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)//указывает на ту область, на которую будет применяться аннотация, FIELD - к полю
//@interface - означает, что это аннотация
@Retention(RetentionPolicy.RUNTIME)//информация о нашей аанотации должна сохраняться вплоть до выполнения кода, то есть до runtime
@Constraint(validatedBy = CheckEmailValidator.class)// указываем наш валидатор-класс, он будет обрабатывать нашу аннотацию
public @interface CheckEmail {

    public String value() default "xyz.com";
    public String message() default "email must ends with xyz.com";

    public Class<?> [] groups() default {};//позволяет разбивать аннотации по группам
    public Class<? extends Payload> [] payload() default {};//перенос информации о метаднных клиента
}

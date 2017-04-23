package com.beangou.year2017.day0423;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by liutongbin on 2017/4/23.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {

    int id();

    String description() default "no description";

    UserCase2 useCase2() default @UserCase2(id=2);

    @interface UserCase2 {
        int id();
        String name() default "no name...";
    }
}



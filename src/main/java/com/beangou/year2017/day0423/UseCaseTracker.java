package com.beangou.year2017.day0423;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by liutongbin on 2017/4/23.
 */
public class UseCaseTracker {

    public static void trackUseCases(List<Integer> useCases, Class<?> cls) {
        for (Method method : cls.getDeclaredMethods()) {
            UseCase useCase = method.getAnnotation(UseCase.class);
            if (useCase != null) {
                System.out.println("found case: id=" + useCase.id() + ", description=" + useCase.description());
            }

        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1 ,2 ,3, 4);
        trackUseCases(list, PasswordUtils.class);
        UseCase.UserCase2 ss = null;
    }

}

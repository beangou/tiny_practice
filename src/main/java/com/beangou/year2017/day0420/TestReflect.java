package com.beangou.year2017.day0420;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/4/20
 * @since 1.0
 */
public class TestReflect {

    @Test
    public void see() throws NoSuchMethodException {
        Method method = this.getClass().getMethod("see", null);
        for (Annotation annotation : method.getAnnotations()) {
            System.out.println("annotation=" + annotation.annotationType().getName());
            System.out.println("annotation=" + annotation.annotationType().getSimpleName());
        }
    }

}

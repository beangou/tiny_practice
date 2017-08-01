package com.beangou.year2017.day0420;

import com.beangou.year2017.Entity;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
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

    @Test
    public void findProperties() throws IllegalAccessException {

        Person person = new Person("beangou", 20, "安徽");

        System.out.println("len=" + Person.class.getFields().length);
        for (Field field : Person.class.getFields()) {
            System.out.println("aaa=" + field.getName());
        }
        System.out.println("len=" + Person.class.getDeclaredFields().length);
        for (Field field : Person.class.getDeclaredFields()) {
            System.out.println("aaa=" + field.getName());
            field.setAccessible(true);
            System.out.println(field.getName() + ":" + field.get(person));
        }
    }

}

class Person extends Entity {

    public Person(String name, int age, String addr) {
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    private int age;

    private String addr;

}



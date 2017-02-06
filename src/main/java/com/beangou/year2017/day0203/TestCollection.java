package com.beangou.year2017.day0203;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liutb on 2017/2/3.
 *
 * @since 1.0.0
 */
public class TestCollection {

    @Test
    public void testSet() {
        String str = "aaa";
        Integer myInt = 2;
        Set<Object> set = new HashSet<>();
        set.add(str);
        set.add(myInt);
        System.out.println(set);
        set.add(2);

        Person person = new Person();
        person.setAge(20);
        person.setName("aaaa");
        set.add(person);
//        try {
//            person.finalize();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        System.out.println(person);
//        person = null;
//        System.gc();
//        System.out.println(set);
    }



}

class Person {
    private String name;
    private int age;

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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public void finalize() throws Throwable {
        System.out.println("开始调用finalize方法");
        super.finalize();
        System.out.println("结束调用finalize方法");
    }
}
package com.beangou.year2017.month02.day0203;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;

import java.util.*;

/**
 * Created by liutb on 2017/2/3.
 *
 * @since 1.0.0
 */
public class TestCollection {


    @Test
    public void testRandom() {
        for (int i = 0; i < 1000; i++) {
            int randomNum = (int)(2*Math.random());
            System.out.println("randomNum =" + randomNum);
        }
    }

    @Test
    public void set2List() {

        String[] keyWordArr = "Rubber hose".split(";");

        for (int i = 0; i < keyWordArr.length; i++) {
            System.out.println("word:" + keyWordArr[i]);
        }

        Map<String, Integer> map = new HashMap<>();
        map.put("111", 111);
        map.put("222", 111);
        map.put("333", 111);
        map.put("444", 111);
        map.put("555", 111);

        List<String> list = new ArrayList<>(map.keySet());
        System.out.println("list=" + list);
    }

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
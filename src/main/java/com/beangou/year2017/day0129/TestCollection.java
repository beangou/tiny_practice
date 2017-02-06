package com.beangou.year2017.day0129;

import org.junit.Test;

import java.util.*;

/**
 * Created by liutb on 2017/1/29.
 *
 * @since 1.0.0
 */
public class TestCollection {

    @Test
    public void testDebug() {
        Map<String, Integer> map = new HashMap<>();
        map.put("上海", 1);
        map.put("北京", 2);
        map.put("广州", 3);
        map.put("天津", 4);
        map.put("重庆", 5);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Test
    public void testMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("111", 111);
        map.put("222", 222);
        System.out.println(map);
        map.put("333", 333);
        map.put("444", 4444);
        map.put("555", 555);
        map.put("6666", 333);
        map.put("7777", 4444);
        map.put("8888", 555);
        map.put("999", 333);
        map.put("10000", 4444);
        map.put("11000", 555);
//        map.put("12000", 333);
//        map.put("13000", 4444);
//        map.put("14000", 555);
//        map.put("15000", 4444);
//        map.put("16000", 555);

        System.out.println(map);
    }

    @Test
    public void testLinkedHashMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("111", 111);
        map.put("222", 222);
        System.out.println(map);
        map.put("333", 333);
        map.put("444", 4444);
        map.put("555", 555);
        map.put("6666", 333);
        map.put("7777", 4444);
        map.put("8888", 555);
        map.put("999", 333);
        map.put("10000", 4444);
        map.put("11000", 555);
        System.out.println(map);

    }

    @Test
    public void testTreeMap() {
        String a = "";
        Object obj = null;
        a.compareTo("");
        Map<Object, Object> map = new TreeMap<>();
//        map.put(new Person(), 222);
        map.put(111, 111);
        map.put("222", 222);
        System.out.println(map);
        map.put("333", 333);
        map.put("444", 4444);
        map.put("555", 555);
        map.put("6666", 333);
        map.put("7777", 4444);
        map.put("8888", 555);
        map.put("999", 333);
        map.put("10000", 4444);
        map.put("11000", 555);
//
        System.out.println(map);
    }


    @Test
    public void testExtendsObj() {
        MyInterface myInterface = null;
        myInterface.toString();
    }

    @Test
    public void testList() {
        List list = new ArrayList();
        list.add(new Dog());
        list.add(new Person());
        Dog dog = (Dog) list.get(1);
        System.out.println(dog);
    }
}

interface MyInterface {

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
}

class Dog {

}

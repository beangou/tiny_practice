package com.beangou.year2017.day0105_multiple_inheritance;

/**
 * Created by liutb on 2017/1/5.
 *
 * @since 1.0.0
 */


public class TestNewClass implements TestNewInterface {
    public static void main(String[] args) {
        new TestNewClass().test();
    }
}

interface TestNewInterface {
    default void test() {
        System.out.println("this is java8");
    }

    static void test(String str) {
        System.out.println(str);
    }

    static void main(String[] args) {

    }
}
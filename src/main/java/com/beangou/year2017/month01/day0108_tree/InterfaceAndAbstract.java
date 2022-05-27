package com.beangou.year2017.month01.day0108_tree;

import java.util.concurrent.Executors;

/**
 * Created by liutb on 2017/1/8.
 *
 * @since 1.0.0
 */
public class InterfaceAndAbstract implements MyInterface{
    private String name;

    public static void main(String[] args) {
//        System.out.println(name);
        new InterfaceAndAbstract().printName();
//        MyInterface.name = "44";
        new TestClass().a = 3;
    }

}

interface MyInterface {
    /**
     * 接口 字段，默认是 static final
     */
    public static final String name = "hello";
    default void printName() {
        System.out.println(name);
    }
}

abstract class MyAbstract {
    int a;
}

class TestClass extends MyAbstract {
    public void see() {
        this.a = 3;
    }
}

interface InterfaceA {
    default void print() {
        System.out.println("helloA");
        Executors.newFixedThreadPool(2);
    }
}

interface InterfaceB extends InterfaceA {
    default void print() {
        System.out.println("helloB");
    }
}

class TestInterface implements InterfaceA, InterfaceB {

    @Override
    public void print() {
        InterfaceB.super.print();
    }

    public static void main(String[] args) {
        new TestInterface().print();
    }
}
package com.beangou.year2017.month03.day0319;

import java.util.Date;

/**
 * Created by liutongbin on 2017/3/19.
 */
public class NormalClass {

    public NormalClass(Date date) {
        System.out.println("!!!!!");
    }

    public NormalClass(String arg) {
//        this();
        System.out.println("22222");
    }

    public NormalClass(String arg1, String arg2) {
//        this();
//        this("aaaa");
        System.out.println("33333");
    }

    @Override
    public void finalize() {
        System.out.println("super class finalize...");
    }

}

class SubClass extends NormalClass {
    public SubClass(String arg) {
        super(new Date());
        System.out.println("arg=" + arg);
    }

    public static void main(String[] args) {
        new SubClass("222222");
        new NormalClass("22211");
        A a = new A();
        B b = new B();
        a.setB(b);
        b.setA(a);

        System.gc();
    }

    @Override
    public void finalize() {
        System.out.println("finalize");
    }
}

class A {
    private B b;
    public A () {

    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}

class B {
    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}
package com.beangou.year2017.day0106_anonimous_class;

/**
 * Created by liutb on 2017/1/6.
 *
 * @since 1.0.0
 */
public class TestAnonimousClass {
    public static void main(String[] args) {
        new MyAbstractClass(){
            @Override
            public void test() {
                System.out.println("sss");
            }
        }.test();
    }
}

abstract class MyAbstractClass {
    public abstract void test();
}
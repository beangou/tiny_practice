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

        getBase(22);
    }

    public static Base getBase(int i) {
        return new Base(i) {
            // 必须有{} 这是没有名字的构造函数
            {System.out.println("inside i" + i);}

            @Override
            public void f() {

            }
        };
    }
}

abstract class MyAbstractClass {
    public abstract void test();
}

abstract class Base {
    public Base (int i) {
        System.out.println("base i=" + i);
    }

    public abstract void f();
}
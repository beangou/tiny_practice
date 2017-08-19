package com.beangou.year2017.month08.day09;

/**
 * Created by liutongbin on 2017/8/9.
 */
public class TestClass {

    private int m;

    public int inc() {
        return m+1;
    }

}

interface A {
    void A();
}

interface B extends A {
    void B();
}

interface C extends B {
    void C();
}

// 虽然C继承了A、B，但还是可以同时实现A、B、C
class ImpleteC implements A, B, C {
//class ImpleteC implements C {

    @Override
    public void A() {

    }

    @Override
    public void B() {

    }

    @Override
    public void C() {

    }
}
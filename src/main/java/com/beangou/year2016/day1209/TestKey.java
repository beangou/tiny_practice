package com.beangou.year2016.day1209;

import org.junit.Test;

/**
 * Created by liutb on 2016/12/9.
 *
 * @since 1.0.0
 */
public class TestKey {
    public static void main(String[] args) {
        AbstractClass clz = new Son();
        clz.testOverride();

        MyInterface myInterface = new Son();
        myInterface.testOverride();
    }

    @Test
    public void testAssert() {
        assert true : "ssskkkksss";
        assert false : "ssskkkksss";
//        assert
        System.out.println("next");
    }
}


abstract class AbstractClass {
    public abstract void testOverride();
}

interface MyInterface {
    public void testOverride();
}

class Son extends AbstractClass implements MyInterface {
    @Override
    public void testOverride() {
//        super.testOverride();
        System.out.println("son is here");

    }
}
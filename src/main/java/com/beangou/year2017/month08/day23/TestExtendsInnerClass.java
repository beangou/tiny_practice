package com.beangou.year2017.month08.day23;

import static com.beangou.year2017.month08.day23.WithInnerClass.*;

/**
 * Created by liutongbin on 2017/8/23.
 */
public class TestExtendsInnerClass {



}

class WithInnerClass {
    class InnerClass {

    }
}

class SubClass extends WithInnerClass.InnerClass {

//    public SubClass(){} compile error

    public SubClass (WithInnerClass withInnerClass) {
        withInnerClass.super();
    }

}
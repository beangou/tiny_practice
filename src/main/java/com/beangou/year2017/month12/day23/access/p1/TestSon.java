package com.beangou.year2017.month12.day23.access.p1;

import org.junit.Test;

/**
 * @author 小彬
 * @version V1.0 2017/12/23 上午8:30
 * @since V1.0
 */
public class TestSon extends TestSuper {

    @Test
    public void see() {
        int a = publicField;
        int b = protectedField;
        int c = friendlyField;
//        int d = privateField; error
    }

//    @Override
    public static void testStaticOverload(String[] args) {
    }

//    @Override // error
    private void testPrivateOverload() {

    }

    @Override
    protected void testProtectedOverload() {

    }


}

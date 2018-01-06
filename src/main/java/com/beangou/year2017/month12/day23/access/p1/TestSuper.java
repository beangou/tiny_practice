package com.beangou.year2017.month12.day23.access.p1;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

/**
 * @author 小彬
 * @version V1.0 2017/12/23 上午8:26
 * @since V1.0
 */
@Getter
@Setter
public class TestSuper {

    private int privateField;

    protected int protectedField;

    int friendlyField;

    public int publicField;

    @Test
    public void testCallPrivate() {
        TestSuper testSuper = new TestSon();
        // 调用的是父类的testPrivateOverload方法
        testSuper.testPrivateOverload();
    }

    public static void testStaticOverload(String[] args) {
    }

    class TestSon extends TestSuper {
        @Test
        public void see() {
            int a = publicField;
            int b = protectedField;
            int c = friendlyField;
            int d = privateField; //error
        }

        private void testPrivateOverload() {
            System.out.println("son method.");
        }

    }

    private void testPrivateOverload() {
        System.out.println("super method.");
    }

    protected void testProtectedOverload() {

    }

}

class TestSon2 extends TestSuper {

    @Test
    public void see() {
        int a = publicField;
        int b = protectedField;
        int c = friendlyField;
//        int d = privateField; //error
    }

}

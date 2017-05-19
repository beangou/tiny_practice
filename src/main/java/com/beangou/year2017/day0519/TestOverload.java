package com.beangou.year2017.day0519;

import org.junit.Test;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/5/19
 * @since 1.0
 */
public class TestOverload {

    @Test
    public void test() {
        new TestOverload().methodA(new Object());
        new TestOverload().methodA("sss");
    }
    
    public void methodA(Object obj) {
        System.out.println("obj method");
    }

    public void methodA(String str) {
        System.out.println("string method");
    }

}

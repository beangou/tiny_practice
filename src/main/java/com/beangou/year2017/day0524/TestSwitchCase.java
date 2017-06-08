package com.beangou.year2017.day0524;

import org.junit.Test;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/5/24
 * @since 1.0
 */
public class TestSwitchCase {

    @Test
    public void test() {

        int a = 1;
        switch (a) {
            case 1: System.out.println("到了1");
            case 2: System.out.println("到了2");
            case 3: System.out.println("到了3");
            default: System.out.println("没找到");
        }

    }

}

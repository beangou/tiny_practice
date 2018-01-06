package com.beangou.year2017.month12.day23.access.p2;

import com.beangou.year2017.month12.day23.access.p1.TestSuper;
import org.junit.Test;

/**
 * @author 小彬
 * @version V1.0 2017/12/23 上午8:28
 * @since V1.0
 */
public class TestSon extends TestSuper {

    @Test
    public void see() {
        int a = publicField;
        int b = protectedField;
//        int c = privateField; compile error
//        int d = friendlyField; compile error
    }

}

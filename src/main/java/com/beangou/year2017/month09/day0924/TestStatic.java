package com.beangou.year2017.month09.day0924;

import org.junit.Test;

/**
 * Created by liutongbin on 2017/9/24.
 */
public class TestStatic {

    static int b = 2;

    @Test
    public void staticProperty() {
        final int a = 2;
        b = 22;
    }

}

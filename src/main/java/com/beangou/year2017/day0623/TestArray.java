package com.beangou.year2017.day0623;

import org.junit.Test;

import java.util.Date;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/6/23
 * @since 1.0
 */
public class TestArray {

    @Test
    public void initArr() {
        Object[] objs = {new Object(), new Object()};

        Integer[][] objects = new Integer[5][3];

        System.out.println("result=" + 1000 * 60 * 60 * 24);

        System.out.println("date=" + new Date(System.currentTimeMillis() - 1000L * 60 * 60 * 24 * 30));

//        for ()

//        compile error.
//        Object[] objs2;
//        objs2 = {new Object(), new Object()};
    }

}

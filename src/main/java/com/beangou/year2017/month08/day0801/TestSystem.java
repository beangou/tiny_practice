package com.beangou.year2017.month08.day0801;

import org.junit.Test;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/8/1
 * @since 1.0
 */
public class TestSystem {

    @Test
    public void findProperties() {
        System.out.println("result=" + System.getProperties().getProperty("os.name").contains("Window"));
    }

}

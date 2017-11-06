package com.beangou.year2017.month07.day0710;

import org.junit.Test;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/7/10
 * @since 1.0
 */
public class TestRuntime {

    @Test
    public void show() {
        long[] arr = new long[1024*1024];
        System.out.println("freeMemory=" + Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println("maxMemory=" + Runtime.getRuntime().maxMemory()/1024/1024);
        System.out.println("availableProcessors=" + Runtime.getRuntime().availableProcessors());
        System.out.println("totalMemory=" + Runtime.getRuntime().totalMemory()/1024/1024);
    }

}

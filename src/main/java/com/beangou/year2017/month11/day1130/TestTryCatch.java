package com.beangou.year2017.month11.day1130;

import org.junit.Test;

/**
 * @author 小彬
 * @version V1.0 2017/11/30 下午4:02
 * @since V1.0
 */
public class TestTryCatch {

    @Test
    public void tryFinally () {

        while (true) {
//        try {
            finallyMethod();
            System.out.println("aaa=" + 222);
//        } catch (Exception e) {
//            System.out.println("exceoption happends");
//            e.printStackTrace();
//        }

        }
    }

    private void finallyMethod() {
        try {
            Thread.State state = Thread.State.TIMED_WAITING;
            System.out.println("try...");
            int a = 2 / 0;
        } finally {
            System.out.println("finally...");
        }
    }

}

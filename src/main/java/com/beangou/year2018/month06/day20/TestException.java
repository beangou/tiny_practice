package com.beangou.year2018.month06.day20;

import org.junit.Test;

/**
 * @author 小彬
 * @version V1.0 2018/6/20 上午9:17
 * @since V1.0
 */
public class TestException {


    @Test
    public void trigger() {
        try {
            // see hahaha
            see();
        } catch (Exception e) {
            System.out.println("catched.");

            e.printStackTrace();
        }
    }

    private void see() {
        int a = 0;
        System.out.println("a=" + a);
        throw new MyException("exception happened.");
    }


}

class MyException extends RuntimeException {

    public MyException(String msg) {
        super(msg);
    }
}
package com.beangou.year2017.month01.day0118_BigDecimal;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by liutb on 2017/1/18.
 *
 * @since 1.0.0
 */
public class TestBigDecimal {
    public static void main(String[] args) {
        while (true) {

        }
//        System.out.println(new BigDecimal("1").negate());
//        System.out.println(new BigDecimal("0.33232"));
//        System.out.println(new BigDecimal("0.6").toString());
    }

    @Test
    public void loop() {
        while (true) {

        }
    }

    @Test
    public void divide() {
        BigDecimal a = new BigDecimal(1).divide(new BigDecimal(3), 2, BigDecimal.ROUND_FLOOR);
        System.out.println("a=" + a);
    }


}

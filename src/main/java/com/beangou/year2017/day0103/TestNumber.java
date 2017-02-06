package com.beangou.year2017.day0103;

import java.math.BigDecimal;

/**
 * 注： 使用BigDecimal的字符串构造函数， 不能使用double构造函数，会计算不准确
 * Created by liutb on 2017/1/3.
 *
 * @since 1.0.0
 */
public class TestNumber {
    public static void main(String[] args) {
        double a = 1.22;
        double floatNum = 0.1f;
        double floatSum = 0;
        BigDecimal bigDecimalNum2 = new BigDecimal(0.1); // 不ok
        BigDecimal bigDecimalNum3 = BigDecimal.valueOf(0.1); // ok
        BigDecimal bigDecimalNum = new BigDecimal("0.1"); // ok
        BigDecimal bigDecimalSum = new BigDecimal(0);
        for (int i = 0; i < 100; i++) {
            floatSum += floatNum;
            bigDecimalSum = bigDecimalSum.add(bigDecimalNum);
        }
        System.out.println("float sum:" + floatSum);
        System.out.println("bigDecimal sum:" + bigDecimalSum);
        System.out.println("float caculate: " + 100 * 0.1);
        System.out.println("bigdecimal caculate: " + new BigDecimal(0.1).multiply(new BigDecimal(100)));

        System.out.println(0.1f*100);

        System.out.println(0.06);
        System.out.println(0.01);
        System.out.println(0.07);
        System.out.println(0.06 + 0.01);
        System.out.println(0.4 + .8);

        System.out.println(new BigDecimal(1.2));
        System.out.println(new BigDecimal(3));
        System.out.println(new BigDecimal(1.2).divide(new BigDecimal(3)));
    }
}

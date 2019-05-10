package com.beangou.year2019.month05;

import org.junit.Test;

/**
 * @author 小彬
 * @version V1.0 2019-05-03 20:41
 * @since V1.0
 */
public class TestOperator {

    /**
     * 异或运算符
     */
    @Test
    public void exclusiveNot() {
        System.out.println("0^1=" + (0^1));
        System.out.println("1^1=" + (1^1));
    }

    /**
     * 左移运算符
     * 二进制向左移动x位数
     */
    @Test
    public void leftShift() {
        System.out.println("1<<3 = " + (1<<3));
        // 10 = 00001010 => 00000101 => 5
        int x = 10 + (10>>1);
        System.out.println("x = " + x);
    }

    /**
     * 右移运算符
     * 二进制向右移动x位数
     */
    @Test
    public void rightShift() {
        System.out.println("8>>3 = " + (8>>3));
    }

    /**
     * 0000 1000
     * 1111 0111 ✅
     * 1 + 2 + 4 + 16 + 32 + 64 = 119 ❌
     */
    @Test
    public void not() {
        System.out.println("~8 = " + (~8));
        System.out.println("11110111=" + (0b11110111));
        System.out.println("=" + Integer.toBinaryString(-9));
    }



}

package com.beangou.back.year2021.month08.day21;

import org.junit.Test;

public class TestBlock {

    {
        // 只有实例化 该类时
        System.out.println("doooooo it");
        fly();
    }

    static {
        System.out.println("static dooooooo it");
//        fly();
    }

    public void fly() {
        System.out.println("just fly");
    }

    public static void main(String[] args) {
        System.out.println("begin...");
        new TestBlock();
        System.out.println("end...");
    }

}

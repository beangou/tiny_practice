package com.beangou.year2016.day1229;

/**
 * Created by liutb on 2016/12/29.
 *
 * @since 1.0.0
 */
public class TestEnum {
    public static void main(String[] args) {
        TestA a = TestA.B;
        switch (a) {
            case A: break;
        }
    }
}

enum TestA {
    A,
    B,
    C
}

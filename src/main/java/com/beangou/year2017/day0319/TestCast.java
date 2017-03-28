package com.beangou.year2017.day0319;

import org.junit.Test;

import java.util.Date;

/**
 * Created by liutongbin on 2017/3/19.
 */
public class TestCast {

    public TestCast() {
        System.out.println("111");
    }

//    public TestCast(String arg1) {
////        this();
//        System.out.println("222");
//    }

    @Test
    public void test() {
        // 精确度可以 由低到高，由高到低，需要强制转化(基本类型， 对于包装类型不可直接转化)
        byte myByte = 122;
        short a = 3;
        a = myByte;
        int b = a;
        a = (short)b;

        Short aa = 3;
//        Integer bb = (Integer)aa;  error


        // 向上转型
        String str = "sss";
        Object obj = str;
        str = (String)obj;

        Date date = new Date();
        // 强制转化，需要是父子类关系
        date = (Date) obj;

    }

}

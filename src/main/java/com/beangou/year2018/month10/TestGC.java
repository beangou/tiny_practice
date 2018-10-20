package com.beangou.year2018.month10;

import org.junit.Test;

/**
 * @author 小彬
 * @version V1.0 2018/10/7 上午10:59
 * @since V1.0
 */
public class TestGC {

    public static int _1M = 1024*1024;
    public static int _2M = 2 * 1024*1024;
    public static int _3M = 3 * 1024*1024;
    public static int _4M = 4 * 1024*1024;

    public int[] new_arr = new int[_1M];

    @Test
    public void eden() {
        byte arr1[] = new byte[_2M];
        byte arr2[] = new byte[_2M];
        byte arr3[] = new byte[_2M];
        byte arr4[] = new byte[_4M];
        System.out.println("hahaha");
//        byte arr5[] = new byte[_4M];
//        byte arr6[] = new byte[_1M];
    }

    @Test
    public void gc() {
        MyObj obj1 = new MyObj(new_arr);
        MyObj obj2 = new MyObj(new_arr);
        MyObj obj3 = new MyObj(new_arr);
        MyObj obj4 = new MyObj(new_arr);
        MyObj obj5 = new MyObj(new_arr);
        MyObj obj6 = new MyObj(new_arr);
        MyObj obj7 = new MyObj(new_arr);
        MyObj obj8 = new MyObj(new_arr);
        MyObj obj9 = new MyObj(new_arr);
        MyObj obj10 = new MyObj(new_arr);
        MyObj obj11 = new MyObj(new_arr);
        MyObj obj12 = new MyObj(new_arr);
//        byte arr1[] = new byte[10 * _2M];
//        System.out.println("hahaha");
    }


    class MyObj {
        public int[] new_arr;
        MyObj(int[] arr) {
            this.new_arr = arr;
        }
    }

}

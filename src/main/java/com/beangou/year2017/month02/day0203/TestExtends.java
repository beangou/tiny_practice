package com.beangou.year2017.month02.day0203;

/**
 * Created by liutb on 2017/2/3.
 *
 * @since 1.0.0
 */
public class TestExtends {
    public static void main(String[] args) {
//     MySuper mySuper = new MySub();
//        String str = "000";
//        MySuper mySuper = new MySub("))))");

        new MySub();
    }
}

class MySuper {

    static int num = 1;

    protected MySuper() {
        System.out.println("this is super");
    }
}

class MySub extends MySuper {

    static int num = 5;

    public MySub() {
//        super();
        System.out.println("num=" + num);
        System.out.println("this is sub");
    }

    public MySub(String str) {
        System.out.println(str);
        System.out.println("this is sub2");
    }
}
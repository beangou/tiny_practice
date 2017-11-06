package com.beangou.year2017.month05.day0531;

/**
 * Created by liutongbin on 2017/5/31.
 */
public class TestExtends {

    public static void main(String[] args) {
//        new Son();
        new Son("8888");
    }

}


class Father {
    public Father() {
        System.out.println("this is father.");
    }

    public Father(String name) {
        System.out.println("this is father who has name." + name);
    }
}

class Son extends Father {
    public Son(String name) {
        /**
         * 所有子类构造函数，如果不指定父类构造函数，会调用父类默认构造函数
         */
                super("abc");
        System.out.println("this is son.");
    }

    /**
     * 如果父类没有该构造方法，会报错
     */
    public Son() {
        this("ddd");
        System.out.println("this is son no parameter.");
    }

    public Son(String name, int age) {
        this();
//        this("sss");
    }

    public void say() {
        System.out.println("son is saying");
    }
}
package com.beangou.year2017.day0203;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by liutb on 2017/2/3.
 *
 * @since 1.0.0
 */
public class TestSingleton {

    // volatile是否必要？
    private static TestSingleton singleton;

    private TestSingleton() {
        System.out.println("new It88555 ...");
    }

    public static TestSingleton getSingleton() {
        if (singleton == null) {
            synchronized (TestSingleton.class) {
                if (singleton == null) {
                    singleton = new TestSingleton();
                }
            }
        }

        return singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    TestSingleton.getSingleton();
                    StaticInitHolderPattern.getSingleton();
                }
            }).start();
        }
    }

}

// 静态初始化占位模式(如果InnerClass去掉static修饰符，可不可以？ 不可以，会编译报错，为何报错？)
// 为何非静态内部类的属性，不能是静态的？ 但是静态内部类的属性、方法可以是非静态的
class StaticInitHolderPattern {

    private static class StaticInnerClass {
//    private  class StaticInnerClass {
        private static final int i = 1;
        private static final MySingleton mySingleton = new MySingleton(1, "beangou");
        public static void say() {
            System.out.println("hhahahha");
        }
    }

    private class NonStaticInnerClass {
//        private static int i = 1;
//        private static final int i;
        private static final int i = 1;
        private static final String a = "2";
//        private static final Object obj = new Object();
//        private static final StringBuilder obj = new StringBuilder();
    }

    public static MySingleton getSingleton() {
        System.out.println("same?" + StaticInnerClass.mySingleton);
        return StaticInnerClass.mySingleton;
    }
}

@Getter
@Setter
class MySingleton {

    private int id;
    private String name;

    public MySingleton(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// compile error
//class SubSingleton extends TestSingleton {
//    public SubSingleton() {
//
//    }
//}
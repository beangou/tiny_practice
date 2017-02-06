package com.beangou.year2017.day0203;

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
                    TestSingleton.getSingleton();
                }
            }).start();
        }
    }

}

// compile error
//class SubSingleton extends TestSingleton {
//    public SubSingleton() {
//
//    }
//}
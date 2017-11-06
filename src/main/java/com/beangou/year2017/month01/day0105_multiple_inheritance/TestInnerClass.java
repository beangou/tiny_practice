package com.beangou.year2017.month01.day0105_multiple_inheritance;

/**
 * Created by liutb on 2017/1/5.
 *
 * @since 1.0.0
 */
public class TestInnerClass {

    private ObjExtendsFather objExtendsFather;
    private ObjExtendsMother objExtendsMother;

    public TestInnerClass() {
        this.objExtendsFather = new ObjExtendsFather("2222");
        this.objExtendsMother = new ObjExtendsMother();
    }

    class ObjExtendsFather extends Father {

        private String name;

        public ObjExtendsFather(String name) {
            name = "sss";
            this.name = name;
        }

    }

    class ObjExtendsMother extends Mother {
    }

    public void strong() {
        this.objExtendsFather.strong();
    }

    public void kind(boolean a) {
        this.objExtendsMother.kind();
        if (a) {
            class InnerClassInMethod implements Runnable {
                @Override
                public void run() {

                }
            }
            new InnerClassInMethod().run();
        }
//        new InnerClassInMethod();
    }

    public static void main(String[] args) {
        new TestInnerClass().strong();
        new TestInnerClass().kind(true);
        new MyInterface(){
            @Override
            public void hello() {
                System.out.println("hello");
            }
        };

//        final String a = "name";
        new MyInterface() {
            @Override
            public void hello() {
                System.out.println("hello");
            }
        };

    }

    interface MyInterface {
        void hello();
    }
}

class Father {
    public void strong() {
        System.out.println("to be strong.");
    }
}

class Mother {
    public void kind() {
        System.out.println("to be kind");
    }
}

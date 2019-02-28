package com.beangou.year2016.day1229;

/**
 * Created by liutb on 2016/12/29.
 *
 * @since 1.0.0
 */
public class TestEnum {
    public static void main(String[] args) {

        for (TestA a : TestA.values()) {
            System.out.println(a.toString());
        }

        TestA a = TestA.B;
        switch (a) {
            case A: break;
        }

//        Enum<TestA> aa = new Enum<TestA>("haha", 1) {};

//        TestA.B = new Enum<TestA>("haha", 1) {};

        TestA.valueOf("A");

        System.out.println("result=" + TestA.A.name());
        System.out.println("result=" + TestA.A.toString());
        System.out.println("result=" + TestA.A.ordinal());
        System.out.println("result=" + TestA.C.ordinal());
        System.out.println("result=" + TestA.C.hashCode());
        System.out.println("result=" + TestA.C.getClass());
    }

    public void analyse(Class clazz) {
        clazz.getGenericInterfaces();
    }
}

enum TestA {
    A {
        @Override
        void sayHello() {}
    },
    B {
        @Override
        void sayHello() {}
    },
    hello {
        @Override
        void sayHello() {}
    },
    FIND_APPLE {
        @Override
        void sayHello() {}
    },
    C {
        @Override
        void sayHello() {}
    };

    abstract void sayHello();

    @Override
    public String toString() {
        return super.toString();
    }
}

//@NoArgsConstructor
//@AllArgsConstructor
enum SexEnum {
    A {
        @Override
        void say() {
            System.out.println("I'm A");
        }
    },
    B((byte)0, "man") {
        @Override
        void say() {
            System.out.println("I'm B");
        }
    },
    ;

    SexEnum() {}

    SexEnum(byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    abstract void say();

    byte code;
    String desc;

}

//class Haha extends SexEnum {
//
//    public Haha(){}
//
//    @Override
//    void say() {
//
//    }
//}
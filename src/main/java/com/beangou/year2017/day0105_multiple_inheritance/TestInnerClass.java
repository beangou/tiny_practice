package com.beangou.year2017.day0105_multiple_inheritance;

/**
 * Created by liutb on 2017/1/5.
 *
 * @since 1.0.0
 */
public class TestInnerClass {

    private ObjExtendsFather objExtendsFather;
    private ObjExtendsMother objExtendsMother;

    public TestInnerClass() {
        this.objExtendsFather = new ObjExtendsFather();
        this.objExtendsMother = new ObjExtendsMother();
    }

    class ObjExtendsFather extends Father {
    }

    class ObjExtendsMother extends Mother {
    }

    public void strong() {
        this.objExtendsFather.strong();
    }

    public void kind() {
        this.objExtendsMother.kind();
    }

    public static void main(String[] args) {
        new TestInnerClass().strong();
        new TestInnerClass().kind();
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

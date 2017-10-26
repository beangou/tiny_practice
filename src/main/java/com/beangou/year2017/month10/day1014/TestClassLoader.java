package com.beangou.year2017.month10.day1014;

import com.beangou.test.Test;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by liutongbin on 2017/10/15.
 */
public class TestClassLoader {

    public static void main(String[] args) {
//        System.out.println("result=" + new Son().getM());
//        System.out.println("result=" + Son.staticM);

        new Test().doSth();
    }

}

@Getter
@Setter
class Super {

    private String m = "super";

    public static String staticM = "superStaticM";

    static {
        System.out.println("comes to super");
    }
}

@Getter
@Setter
class Father extends Super {

    private String m = "father";

    static {
        staticM = "father static";
//        String a = staticM;    // static在声明之前，只能赋值，不能使用
        System.out.println("comes to father");
    }

    public static String staticM = "fatherStaticM";


}

interface SuperInterface {
    // 接口和父类同时存在变量，引用该变量时，会编译报错
    String staticM = "interfaceStaticM";
}

@Getter
@Setter
//class Son extends Father implements SuperInterface {
class Son extends Father {
    public static String SON_STR = staticM;
    static {
        System.out.println("comes to son");
    }
}

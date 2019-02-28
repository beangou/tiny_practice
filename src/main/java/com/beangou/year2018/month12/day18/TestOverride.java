package com.beangou.year2018.month12.day18;

import org.junit.Test;

/**
 * @author 小彬
 * @version V1.0 2018-12-18 23:32
 * @since V1.0
 */
public class TestOverride {

    @Test
    public void testStatic() {
        Father father = new Son();
        // 调用的是父类的静态方法
//        father.haha();
    }

}

class Father {
    void say(){}
    void say(Object args){}
    Object say2(){
        return "";
    }

    public static void haha() {
        System.out.println("father hahaha");
    }


}

abstract class AbstractSon extends Father {

    /**
     * 形参必须相同，否则不叫覆盖
     * @param args
     */
    void say(String args) throws Exception {}

    /**
     * 抽象方法可以覆盖非抽象方法
     * @return
     */
    @Override
    abstract Object say2();
}

class Son extends Father {

    /**
     * 使用private会编译报错，方法访问修饰符的限制不能低于父类方法
     * 抛出异常，只能不抛出或者抛出其子类
     */
    @Override
    protected void say() {}

    /**
     * 返回值类型b必须相同,
     * 但是覆盖方法返回值类型可以是被覆盖方法返回值类型的子类
     * @return
     */
    @Override
    String say2() {return "";}

    /**
     * 静态方法不存在覆盖一说
     * 父类的非静态方法不能被子类覆盖为静态方法
     * 为什么？ 覆盖依赖于类的实例，发生在运行时（java多态发生在运行时），而静态方法在编译时已经确定
     */
//    @Override
    public static void haha() {
        System.out.println("son hahaha");
    }

    /**
     * 形参必须相同，否则不叫覆盖
     * @param args
     */
    void say(String args) throws NullPointerException {}

}

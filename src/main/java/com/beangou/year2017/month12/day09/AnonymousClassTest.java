package com.beangou.year2017.month12.day09;

import com.beangou.year2017.Entity;

import java.util.HashMap;

/**
 * @author 小彬
 * @version V1.0 2017/12/9 下午10:52
 * @since V1.0
 */
public class AnonymousClassTest {

    {

        System.out.println("comes here...");
    }

    static {
        System.out.println("static comes here....");
    }

    public static void main(String[] args) {

        HashMap<String, String> map3 = new HashMap() {
            {
                put("A", "1");
                put("B", "2");
                String aa = (String)get("aa");
            }
        };

        System.out.println("map=" + map3 + ", class=" + map3.getClass());

        new AnonymousClassTest().takeALookAbstract("aaa");

        OutClass outClass = new OutClass();
        System.out.println("result1=" + outClass.getInnerClass(-1, "name1"));
        System.out.println("result2=" + outClass.getInnerClass(5, "name2"));
    }

    public void takeALookInterface(final String theName2) {
        new MyInterface() {
            @Override
            public void sayHello() {
                System.out.println("theName=" + theName2);
            }
        }.sayHello();
    }

    public void takeALookAbstract(final String theName) {
        MyAbstractClass myAbstractClass = new MyAbstractClass("haha") {
            @Override
            void getName() {
                String copy = theName;
                copy = "bbb";
                System.out.println("name=" + copy);
                System.out.println("origin name=" + theName);
            }
        };
        myAbstractClass.getName();
    }

}

/**
 * 抽象类可以有自己的构造函数
 * abstract和static不能同时出现在一个方法上（如果是static，说明就是类本身的方法，必须自己实现）
 */
abstract class MyAbstractClass {

    private String name;

    public MyAbstractClass() {}

    public MyAbstractClass(String name) {
        this.name = name;
    }


//    abstract static void getNme();

    abstract void getName();

    static void print() {
        System.out.println("hahah");
    }

}

/**
 * 接口不能有构造函数
 */
interface MyInterface {
    public String name = "haha";

//
//    MyInterface ();

    void sayHello();

    default int MyIntesrface () {
        return 0;
    }
}

abstract class InnerClass extends Entity {

    private String name;

    private int age;

    public InnerClass(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("call super constructor.");
    }

    public abstract String getName();
}

/**
 *
 */
class OutClass {

    private String outName;

    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        outClass.outName = "gaga";
        InnerClass innerClass = outClass.getInnerClass(11, "aaa");
        innerClass.getName();
    }

    public InnerClass getInnerClass(final int age,final String name){

        return new InnerClass(name, age) {

            int age_ ;
            String name_;
            //构造代码块完成初始化工作
            {
                if(0 < age && age < 200){
                    age_ = age;
                    name_ = name;
                }
            }
            public String getName() {
                System.out.println("outName="+outName);
                System.out.println("outName="+OutClass.this.outName);
                return name_;
            }

            public int getAge() {
                return age_;
            }
        };
    }
}

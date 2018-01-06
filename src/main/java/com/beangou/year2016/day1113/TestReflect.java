package com.beangou.year2016.day1113;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

/**
 * Created by liutb on 2016/11/13.
 *
 * @since 1.0.0
 */
public class TestReflect {

    private TestReflect() {

    }

    private TestReflect(String name) {

    }

    public TestReflect(int age) {

    }

    public TestReflect(Float height) {

    }

    TestReflect(double a) {

    }

    public static void main(String[] args) {
        Constructor[] cs = TestReflect.class.getConstructors();
        System.out.println("cs len =" + cs.length);
        for (int i = 0; i < cs.length; i++) {
            System.out.println("getConstructors=>"+cs[i].getModifiers() + " " + cs[i].getName() + " parameter+>");
            Parameter[] parameters = cs[i].getParameters();
            for (int j = 0; j < parameters.length; j++) {
                System.out.println(parameters[j].getType().getName());
            }
        }

        System.out.println("***********");
        Constructor[] cs2 = TestReflect.class.getDeclaredConstructors();
        System.out.println("cs2 len =" + cs2.length);
        for (int i = 0; i < cs2.length; i++) {
            System.out.println("getDeclaredConstructors=>"+cs2[i].getModifiers() + " " + cs2[i].getName() + " " + cs2[i].getParameters());
        }
        int[] arr = new int[]{1, 3, 6, 88};
        int[] newArr = (int[])goodCopyArray(arr, 6);
        System.out.println(newArr.length);
        Class cls = System.class;
        try{
            // 显式参数， 隐式参数
            cls.getMethods()[0].invoke(new int[7]);
        } catch(Exception e) {

        }
    }

    // 一个接口可以继承多个接口
    interface MyInteface extends Runnable, Serializable {

    }

    public static Object goodCopyArray(Object obj, int newLength) {
        Class clz = obj.getClass();
        if(!clz.isArray()) {return null;}
        Class componentType = clz.getComponentType();
        Object newArr = Array.newInstance(componentType, newLength);
        int length = Array.getLength(obj);
        System.arraycopy(obj, 0, newArr, 0, Math.min(length, newLength));
        return newArr;
    }


//    @Test
}


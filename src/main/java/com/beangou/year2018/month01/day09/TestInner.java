package com.beangou.year2018.month01.day09;


import com.beangou.year2017.month01.day0105_multiple_inheritance.Outter;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 小彬
 * @version V1.0 2018/1/9 下午11:12
 * @since V1.0
 */
public class TestInner {

    private static class NonStaticInner {
        private static int age = 3;
    }

    private class NonStaticInner2 {
//        非静态内部类不允许有静态变量
//        private static int age = 3; compile error
    }

    @Test
    public void see2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Outter outter = new Outter();
        Class[] classes = Outter.class.getDeclaredClasses();
        Constructor constructor = classes[0].getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        Object inner = constructor.newInstance(outter);
        Method method = inner.getClass().getDeclaredMethod("doTest");
        method.setAccessible(true);
        method.invoke(inner);
    }

    @Test
    public void see3() {
        try {
            Outter outter =  new Outter();

            Field[] fields = Outter.class.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
            }

            Constructor fieldConstructor = fields[0].getClass().getConstructors()[0];
            fieldConstructor.setAccessible(true);
            Object object = fieldConstructor.newInstance(outter);

            Class clazz = Class.forName("com.beangou.year2017.month01.day0105_multiple_inheritance.Outer$Inner");
            Object obj = clazz.newInstance();
            System.out.println("obj=" + obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void see() {
        try {
            Outter outter = new Outter();
//            Outer.class.getField("")
//            Object innerInstance1 = Outer.class.getDeclaredField("inner").getType().newInstance();
//            Object innerInstance2 = outer.getClass().getDeclaredField("inner").getType().newInstance();

            Field[] fields = outter.getClass().getDeclaredFields();
//            Object obj = fields[0].getType().getDeclaredConstructors()[0].newInstance();
            fields[0].getClass().getMethods()[0].invoke(fields[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

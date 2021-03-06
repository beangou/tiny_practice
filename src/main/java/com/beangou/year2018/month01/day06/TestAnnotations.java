package com.beangou.year2018.month01.day06;

import com.beangou.year2017.month01.day0103.TestNumber;
import org.junit.Test;

import javax.annotation.PostConstruct;
import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 小彬
 * @version V1.0 2018/1/6 下午9:57
 * @since V1.0
 */

public class TestAnnotations {

    @Test
    public void testInherted() {
        TestNumber testNumber = new TestNumber();
// 默认构造函数的访问权限和其所在当前类访问权限相同
        //        SeeAccess seeAccess = new SeeAccess();
        System.out.println("len=" + Son.class.getAnnotations().length);
        System.out.println("len=" + Son.class.getDeclaredAnnotations().length);
        System.out.println("len=" + Son.class.getConstructors().length);
        System.out.println("len=" + Son.class.getDeclaredConstructors().length);

    }

    @Test
    public void run() throws IllegalAccessException, InstantiationException {
        System.out.println("class =" + BeangouClass.class.isAnnotationPresent(BeangouAnnotation4Class.class));
        BeangouAnnotation4Class beangouAnnotation4Class = BeangouClass.class.getAnnotation(BeangouAnnotation4Class.class);
        System.out.println("class annotation info:" + beangouAnnotation4Class.author());
        System.out.println("class annotation info:" + beangouAnnotation4Class.passNum());
        System.out.println("class annotation info:" + beangouAnnotation4Class.runNum());

        Method[] methods = BeangouClass.class.getMethods();
        BeangouClass instance = BeangouClass.class.newInstance();
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeangouAnnotation4Method.class)) {
                BeangouAnnotation4Method beangouAnnotation4Method = method.getDeclaredAnnotation(BeangouAnnotation4Method.class);
//                BeangouAnnotation4Method beangouAnnotation4Method = method.getAnnotation(BeangouAnnotation4Method.class);
                if (!beangouAnnotation4Method.enabled()) {
                    continue;
                }
                System.out.println("method name=" + method.getName());
                try {
                    method.invoke(instance, null);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

@BeangouAnnotation4Class(passNum = 3)
class BeangouClass {
    @BeangouAnnotation4Method
    public void see() {
        if (true) {
            System.out.println("passed");
        }
    }

    @BeangouAnnotation4Method(enabled = false)
    public void see2() {
        if (true) {
            throw new RuntimeException("big exception.");
        }
    }
}


@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface BeangouAnnotation4Method {
    boolean enabled() default true;
}

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface BeangouAnnotation4Class {
    String author() default "beangou";
    int runNum() default 0;
    int passNum();
// error
//    int hashCode();
}

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface AnnotationSuper {
    boolean ok();
}

@AnnotationSuper(ok=true)
class Super {
}

class Son extends Super {
//    public Son() {
//
//    }
}

interface MyInterface {

}

//注解不可继承或者实现接口
//@interface MyAnnotation extends or implements MyInterface {
//
//}

//注解不支持继承
//@interface TestAnnotationInherit extends AnnotationSuper {
//
//}
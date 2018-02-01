package com.beangou.year2018.month01.day19.proxycglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author 小彬
 * @version V1.0 2018/1/19 下午10:26
 * @since V1.0
 */
public class TestCglibProxy {

    @Test
    public void see() {
        MyClass myClass = (MyClass)Enhancer.create(MyClass.class, new MyInterceptor());
        myClass.hello();
    }

}

class MyClass {
    public void hello() {
        System.out.println("hello world.");
    }
}

class MyInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("comes intercept");
//        System.out.println("obj=" + o +", methodProxy=" + methodProxy);
        return methodProxy.invokeSuper(o, objects);
//        method.invoke(o, objects);
//        return null;
    }
}

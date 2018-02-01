package com.beangou.year2018.month01.day19.proxyjdk;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 小彬
 * @version V1.0 2018/1/19 下午10:12
 * @since V1.0
 */
public class TestJdkProxy {

    @Test
    public void testDate() {
        System.out.println("time=" + System.currentTimeMillis());
    }

    @Test
    public void testJdk() {
        MyInterface myInterface = (MyInterface)Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{MyInterface.class}, new JdkProxyClass(new MyClass()));
        myInterface.hello();
    }

}

interface MyInterface {
    void hello();
}

class MyClass implements MyInterface {

    @Override
    public void hello() {
        System.out.println("hello world.");
    }
}

class JdkProxyClass implements InvocationHandler {

    private MyInterface myInterface;

    public JdkProxyClass (MyInterface myInterface) {
        this.myInterface = myInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("hahaha it comes here.");
//        System.out.println("proxy=" + proxy);
//        method.invoke(proxy, args);
        return method.invoke(myInterface, args);
//        return null;
    }
}

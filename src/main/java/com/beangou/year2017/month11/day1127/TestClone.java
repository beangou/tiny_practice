package com.beangou.year2017.month11.day1127;

import com.beangou.year2017.Entity;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.List;


/**
 * @author 小彬
 * @version V1.0 2017/11/27 下午10:17
 * @since V1.0
 */
public class TestClone {

    /**
     * java.lang.CloneNotSupportedException
     */
    @Test
    public void testNoImplementsCloneable() {
        B b = new B();
        b.clone();
    }

    @Test
    public void testShallowClone() {
        A a = new A();
        System.out.println("a=" + a + ", clone=" + a.clone());

        a.setName("aaa");
        D d = new D(a);
        D dClone = (D)d.clone();
        System.out.println("dClone=" + dClone);
        a.setName("bbb");
        System.out.println("dClone=" + dClone);
    }

    @Test
    public void testDeepClone() {
        A a = new A();
        a.setName("aaa");
        C c = new C(a);
        C clone = (C)c.clone();
        System.out.println("c=" + c + "汉字, clone=" + clone);
        a.setName("bbbb");
        System.out.println("c=" + c + ", clone=" + clone);
//        Thread.State.TIMED_WAITING;
//        new Thread().join();
    }

    @Test
    public void testArrClone() {
        String[] arr = new String[3];
        arr[0] = "aaa";
        arr[1] = "bbb";
        arr[2] = "ccc";
        E e = new E(arr);
        E clone = (E)e.clone();
        System.out.println("arr=" + clone);
        arr[1] = "eeee";
        System.out.println("arr=" + clone);
    }

    @Test
    public void testCloneMore() {
        A a = new A();
        A b = new A();
        A c = new A();
        a.setName("a");
        b.setName("b");
        c.setName("c");
        A[] arr = {a, b, c};
        F f = new F(arr);
        F clone = (F)f.clone();
        System.out.println("clone=" + clone);
        b.setName("kkk");
        System.out.println("clone=" + clone);
    }

}

@Getter
@Setter
class A extends Entity implements Cloneable {

    public A() {
        System.out.println("execute A Constructor");
    }

    private String name;

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

class B {

    @Override
    public B clone() {
        try {
            return (B)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

}

@Setter
@Getter
class C extends Entity implements Cloneable {

    private A a;

    public C (A a) {
        this.a = a;
    }

    @Override
    public Object clone() {
        try {
            C c = (C)super.clone();
            c.a = (A)a.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }


}

@Setter
@Getter
class D extends Entity implements Cloneable {

    private A a;

    public D (A a) {
        this.a = a;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

}

@Getter
@Setter
class E extends Entity implements Cloneable {

    private String[] arr;

    public E(String[] arr) {
        this.arr = arr;
    }

    @Override
    public Object clone() {
        try {
            E e = (E)super.clone();
            e.arr = arr.clone();
            return e;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

}

@Getter
@Setter
class F extends Entity implements Cloneable {

    private A[] arr;

    public F(A[] arr) {
        this.arr = arr;
    }

    @Override
    public Object clone() {
        try {
            F f = (F)super.clone();
            // 这样不是深拷贝
            f.arr = arr.clone();
            return f;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

}
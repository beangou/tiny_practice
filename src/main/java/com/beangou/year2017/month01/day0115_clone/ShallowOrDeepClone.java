package com.beangou.year2017.month01.day0115_clone;

import org.junit.Test;

/**
 * Created by liutb on 2017/1/15.
 *
 * @since 1.0.0
 */
public class ShallowOrDeepClone implements Cloneable {

    public static void main(String[] args) {
//        ShallowOrDeepClone sd = new ShallowOrDeepClone();
        Test2 test2 = new Test2();
//        System.out.println(sd + " => " + sd.clone());  //������clone�����ᱨ��
        System.out.println(test2 + " => " + test2.clone());
    }

    @Override
    public Object clone() {
        try {
            return super.clone(); // ��ʵ��Cloneable�ӿ� �����쳣
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void testAssignment() {
        CopyObj obj = new CopyObj();
        CopyObj obj2 = obj;
        obj.setName("aaaa");
        System.out.println("obj=" + obj);
        System.out.println("obj2=" + obj2);
        System.out.println(obj == obj2);
    }
}

class Test2 implements Cloneable {

    private ShallowOrDeepClone shallowOrDeep;

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

class CopyObj {
    private String name;
    @Override
    public String toString() {
//        System.out.println("CopyObj[name="+name+"]");
        return "CopyObj[name="+name+"]";
    }

    public void setName(String name) {
        this.name = name;
    }
}

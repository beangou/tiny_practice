package com.beangou.year2017.month02.day0226;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/2/26
 * @since 1.0
 */
public class TestEqual {

    @Test
    public void integerEqual() {
//        128 > var >= -128 有缓存问题？ == 到底是怎么比较的

        int a = 100;
        Integer b = 100;
        int c = 1000;
        Integer d = 1000;
        int e = 10000;
        Integer f = 10000;

        System.out.println("a == b " + (a == b));
        System.out.println("c == d " + (d == c));
        System.out.println("e == f " + (e == f));

        Integer.valueOf(100);
    }

    @Test
    public void testByteEqual() {

        String str = "aa ds\ndsds  ";
        System.out.println("st=" + str.trim());

        System.out.println("date=" + new Date(1488250253961L));

        Byte a = 1;
        Byte b = 1;
        byte c = 1;
        Byte d = new Byte((byte) 1);
        Byte e = new Byte((byte) 1);
        Byte f = new Byte((byte) 1);
        System.out.println("a == b:" + (a == b));
        System.out.println("a == c:" + (a == c));
        System.out.println("a == d:" + (a == d));
        System.out.println("a == e:" + (a == e));
        System.out.println("a == f:" + (a == f));

        System.out.println("a.equals(d):" + (a.equals(d)));
        System.out.println("a.equals(e):" + (a.equals(e)));
        System.out.println("a.equals(f):" + (a.equals(f)));
        System.out.println("aaa=" + (MyByteEnum.ONE.getCode() == a));
        System.out.println("enum = d" + (MyByteEnum.ONE.getCode() == d));
    }


    @Test
    public void testByteListContains() {

        System.out.println("result=" + (8 + (8 >> 1)));

        List<Byte> list = new ArrayList<>();
        list.add(new Byte("1"));
        list.add(new Byte("1"));
        list.add(new Byte("2"));

        System.out.println("result=" + list.contains(new Byte((byte)1)));
    }

}

enum MyByteEnum {

    ONE((byte)1);

    private Byte code;

    MyByteEnum(Byte code) {
        this.code = code;
    }

    public Byte getCode() {

        return code;
    }

    public void setCode(Byte code) {
        this.code = code;
    }
}

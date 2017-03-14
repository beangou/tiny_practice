package com.beangou.year2017.day0226;

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
    }


    @Test
    public void testByteListContains() {
        List<Byte> list = new ArrayList<>();
        list.add(new Byte("1"));
        list.add(new Byte("1"));
        list.add(new Byte("2"));

        System.out.println("result=" + list.contains(new Byte((byte)1)));
    }

}

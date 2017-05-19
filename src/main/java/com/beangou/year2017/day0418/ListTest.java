package com.beangou.year2017.day0418;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/4/18
 * @since 1.0
 */

public class ListTest {

    @Test
    public void ss() {
        List<Father> fatherList = new ArrayList<>();
        fatherList.add(new SonA());
        fatherList.add(new SonB());
        fatherList.add(new Father());
        System.out.println("fatherList=" + fatherList);
    }

    @Test
    public void add2First() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        System.out.println("list=" + list);
        list.add(0, 1);
        list.add(0, 2);
        System.out.println("list=" + list);
    }

    @Test
    public void shuffle() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        System.out.println("list1=" + list);
        Collections.shuffle(list);
        System.out.println("list2=" + list);
    }


}

class Father {

}

class SonA extends Father {

}

class SonB extends Father {

}

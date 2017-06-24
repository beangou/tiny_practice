package com.beangou.year2017.day0418;

import org.junit.Test;

import java.util.*;

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
    public void testLinkList() {
        // 双向非循环列表
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.remove(2);
        linkedList.getFirst();
    }

    @Test
    public void retailAll() {
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);

//        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        // 调用retailAll方法会抛异常，因为asList返回的类，没有实现retailAll方法，调用的是是其父类方法， 其父类直接跑出unsupported异常了

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(4);
        list2.add(5);

        list1.retainAll(list2);
        System.out.println("list1="+list1);
    }

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

package com.beangou.year2017.month01.day0108_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutb on 2017/1/8.
 *
 * @since 1.0.0
 */
public class TestGeneric {
//    private List<? extends Number> list = new ArrayList<? extends Integer>();

    private List<? super Integer> list2 = new ArrayList<>();

//    private List<? extends MyInteger> list3 = new ArrayList<? extends SonOfMyInteger>();


    public static void main(String[] args) {
//        list.add()
        List<MyInteger> list = new ArrayList<>();
        list.add(new MyInteger());

        List<SonOfMyInteger> list2 = new ArrayList<>();
        list2.add(new SonOfMyInteger());

        go(list);
        go(list2);



        TestGeneric generic = new TestGeneric();
        generic.add();
    }

    public void add() {
//        list.get(0);
//        list.add(new Integer(22)); error
        list2.add(new Integer(22));
//        list2.add(new Object());

        List<MyInteger> list = new ArrayList<>();
        List<SonOfMyInteger> list2 = new ArrayList<>();
        list.add(new SonOfMyInteger());
        SonOfMyInteger myInteger = (SonOfMyInteger) list.get(0);
        System.out.println(myInteger);
//        list2.add(new MyInteger()); error
        System.out.println(list.size());
    }

    private static void go(List<? extends MyInteger> intList) {
        System.out.println(intList);
    }

}

class MyInteger {

}

class SonOfMyInteger extends MyInteger {

}

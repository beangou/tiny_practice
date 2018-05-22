package com.beangou.year2018.month04;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author 小彬
 * @version V1.0 2018/4/11 下午12:48
 * @since V1.0
 */
public class TestLinkedList {

    @Test
    public void see() {

        System.out.println(">> " + (4 >> 1));

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(2);
        linkedList.addFirst(4);
        linkedList.get(0);
        System.out.println("result= " + linkedList);
        linkedList.clear();
        System.out.println("result= " + linkedList);
    }

}

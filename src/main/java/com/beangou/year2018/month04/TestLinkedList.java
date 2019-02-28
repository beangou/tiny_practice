package com.beangou.year2018.month04;

import org.apache.commons.collections.collection.SynchronizedCollection;
import org.apache.commons.collections.list.SynchronizedList;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author 小彬
 * @version V1.0 2018/4/11 下午12:48
 * @since V1.0
 */
public class TestLinkedList {



    @Test
    public void see() {

        System.out.println(">> " + (4 >> 1));

        LinkedList linkedList = new LinkedList<>();

        ConcurrentLinkedDeque deque = new ConcurrentLinkedDeque();

        List linkedList2 = Collections.synchronizedList(linkedList);
        linkedList = (LinkedList)Collections.synchronizedCollection(linkedList);

//        SynchronizedList linkedList2 = (Collections.SynchronizedRandomAccessList)Collections.synchronizedList(linkedList);

        linkedList.add(2);
        linkedList.addFirst(4);
        linkedList.get(0);
        System.out.println("result= " + linkedList);
        linkedList.clear();
        System.out.println("result= " + linkedList);
    }

}

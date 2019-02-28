package com.beangou.year2019.month01.day24;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;

/**
 * @author 小彬
 * @version V1.0 2019-01-24 20:02
 * @since V1.0
 */
public class TestParalleStream {

    @Test
    public void see() {
        for (int i = 0; i < 10000; i++) {
            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> list2 = Collections.synchronizedList(new ArrayList<>());
            ConcurrentLinkedDeque<Integer> deque = new ConcurrentLinkedDeque();
            LinkedList<Integer> linkedList = new LinkedList();

            List<Integer> list3 = new ArrayList<>();
            list.parallelStream().forEach(e->list2.add(e));

            List<Integer> list4 = list.parallelStream().collect(Collectors.toList());
            list.parallelStream().forEach(e->deque.addFirst(e));
            list.parallelStream().forEach(e->linkedList.addFirst(e));
//            list.parallelStream().re
            list.stream().forEach(e->list3.add(e));
            System.out.println("list2=" + list2);
            System.out.println("list3=" + list3);
            System.out.println("list4=" + list4);
            System.out.println("deque=" + deque);
            try {
                System.out.println("linkedList.size=" + linkedList.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

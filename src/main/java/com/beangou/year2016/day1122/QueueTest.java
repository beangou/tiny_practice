package com.beangou.year2016.day1122;


import java.util.*;

/**
 * Created by liutb on 2016/11/22.
 *
 * @since 1.0.0
 */
public class QueueTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        String last = map.put("aa", "rrr");
        System.out.println(last);
        String last2 = map.put("aa", "rrssr");
        System.out.println(last2);
        map.put(null, null);

        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put(null, null);

//        Map<String, String> sortedMap = new SortedMap<String, String>();
        testLinkedList();
    }



    public static void testLinkedList() {
        Queue<String> queues = new LinkedList<>();
        queues.add("1111");
        queues.add("2222");
        queues.add("3333");
        queues.add("4444");
        String head = queues.remove();

        for(String que : queues)
            System.out.println(que);
    }
}

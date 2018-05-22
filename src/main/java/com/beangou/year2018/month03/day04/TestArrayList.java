package com.beangou.year2018.month03.day04;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 小彬
 * @version V1.0 2018/3/4 下午12:22
 * @since V1.0
 */
public class TestArrayList {

    public ArrayList<Integer> list = new ArrayList<>();

    @Test
    public void filter() {
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.forEach(e -> {

        });

        list.contains("");

        List result = list.stream().filter(e->e > 3).collect(Collectors.toList());
        System.out.println("result=" + result + ". list=" + list);
    }

    @Test
    public void linkedList() {
        // best-effort
        // 双向链表
        // 双向循环链表
        LinkedList<Integer> linkedList = new LinkedList();
        linkedList.add(99);
        linkedList.get(22);
    }

    @Test
    public void remove() {
        List<String> list = new ArrayList<>();
        list.add("11");
        list.add("22");
        list.add("33");
        list.add("44");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String ele = iterator.next();
            if ("22".equals(ele)) {
                iterator.remove();
            }
        }
        System.out.println("len=" + list.size() + ", list=" + list);
    }

    @Test
    public void copy() {
        // 询盘  微信 支付宝
        List<Integer> source = new ArrayList(Arrays.asList(1, 2, 3, 4));
        List<Integer> dest = new ArrayList(Arrays.asList(6, 7, 8, 9));

//        source.addAll(2, dest);
        dest.addAll(source);
        dest.add(3);

        System.arraycopy(source.toArray(), 0, dest.toArray(), 4, 4);
        System.out.println("result=" + source);
    }

    @Test
    public void size() {
        list.trimToSize();
        list.add(1);
        int oldCapacity = 9;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        System.out.println("newCapacity=" + newCapacity);
    }

}

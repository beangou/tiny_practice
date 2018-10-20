package com.beangou.year2016.day1120;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutb on 2016/11/20.
 *
 * @since 1.0.0
 */
public class TestCollection {

    @Test
    public void eleType() {
        List<Object> list = new ArrayList<>(5);
        list.add(2);
        list.add("dd");
        System.out.println("list=" + list);
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");

        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("6");

        list1.addAll(list2);
        System.out.println("retail result=" + list1);

        boolean b = list1.retainAll(list2);
        System.out.println("retail result=" + list1);
        list1.removeAll(list2);
        for (String str: list1) {
            System.out.println(str);
        }
    }
}

package com.beangou.year2016.day1230;

import java.util.*;

/**
 * Created by liutb on 2016/12/30.
 *
 * @since 1.0.0
 */
public class TestOverload {

    public static void myCollection(Collection<?> collection) {
        System.out.println("unknown");
    }

    public static void myCollection(Set<?> set) {
        System.out.println("hashset");
    }

    public static void myCollection(List<?> list) {
        System.out.println("list");
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {new HashSet(), new HashMap().values(), new ArrayList<Object>()};
        for (int i = 0; i < collections.length; i++) {
            myCollection(collections[i]);
        }

        myCollection(new ArrayList<Object>());
    }

}

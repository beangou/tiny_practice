package com.beangou.year2017.day0313;

import org.junit.Test;

import java.util.*;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/3/13
 * @since 1.0
 */
public class TestClassCast {

    @Test
    public void cast() {
        MySuper mySuper = new MySuper();
        MySub mySub = (MySub)mySuper;
    }

    @Test
    public void set() {
        Set<String> set = new HashSet<>();
        set.add("111");
        set.add("222");
        for (String str : set) {
            System.out.println("ele=" + str);
        }
        set.remove("111");
        set.remove("222");
        for (String str : set) {
            System.out.println("ele=" + str);
        }
    }

    @Test
    public void remove() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

//        int len = list.size();
//        for(int i = 0; i< len ; i ++) {
//            if (list.get(i).equals("3")) {
//                list.remove(i);
//            }
//        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println("str=" + str);
            if ("3".equals(str) || "2".equals(str)) {
                iterator.remove();
            }
        }
        System.out.println("list=" + list);
    }

}

class MySuper {

}

class MySub extends MySuper {

}
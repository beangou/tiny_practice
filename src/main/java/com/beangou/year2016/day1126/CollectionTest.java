package com.beangou.year2016.day1126;

import org.junit.Test;

import java.util.*;

/**
 * Created by liutb on 2016/11/26.
 *
 * @since 1.0.0
 */
public class CollectionTest {

    @Test
    public void checkedView() {
        List<String> list = new ArrayList();
        List list2 = list;
        list2.add(new Date());
        System.out.println(list2);
        System.out.println(list);

//        System.out.println(list.get(0));  error

        List<String> list3 = Collections.checkedList(list, String.class);
        list2 = list3;
//        list2.add(new Date()); error
        System.out.println(list2);

        List<String> list5 = Arrays.asList("dd", "dd");
        System.out.println(list5);

        String[] arr = {"aa", "ss"};
        list = Arrays.asList(arr);

        System.out.println(list);

        String[] arr2 = (String[])list.toArray();
        System.out.println(arr2.length);
        System.out.println(arr2[0]);
        System.out.println(arr2[1]);
        arr2 = list.toArray(new String[2]);
        System.out.println(arr2[1]);

        System.out.println(list);
//        list.add(2, new StringBuffer().toString());
//        System.out.println(list);
        String a = Collections.max(list);
        System.out.println(a);
    }


}

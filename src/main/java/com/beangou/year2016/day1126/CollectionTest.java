package com.beangou.year2016.day1126;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liutb on 2016/11/26.
 *
 * @since 1.0.0
 */
public class CollectionTest {

    @Test
    public void see() {

        List<Integer> resultList = new CopyOnWriteArrayList();
        Integer[] intArr = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13};
        List<Integer> list = Arrays.asList(intArr);
        int len = list.size();
        System.out.println("11=" + list.subList(0, len/5));
        System.out.println("11=" + list.subList(len/5, 2*len/5));
        System.out.println("11=" + list.subList(2*len/5, 3*len/5));
        System.out.println("11=" + list.subList(3*len/5, 4*len/5));
        System.out.println("11=" + list.subList(4*len/5, 5*len/5));


        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(() -> resultList.addAll(list.subList(0, len/5)));
        executorService.submit(() -> resultList.addAll(list.subList(len/5, 2*len/5)));
        executorService.submit(() -> resultList.addAll(list.subList(2*len/5, 3*len/5)));
        executorService.submit(() -> resultList.addAll(list.subList(3*len/5, 4*len/5)));
        executorService.submit(() -> resultList.addAll(list.subList(4*len/5, 5*len/5)));
        System.out.println("sss=" + resultList);
    }

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

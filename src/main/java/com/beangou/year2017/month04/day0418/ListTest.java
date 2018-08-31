package com.beangou.year2017.month04.day0418;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/4/18
 * @since 1.0
 */

public class ListTest {

//    static ArrayList<Integer> list = new ArrayList<Integer>();
    static List<Integer> list = new CopyOnWriteArrayList();

    @Test
    public void testVector() {

        System.out.println("result=" + (5+(5>>1)));
        System.out.println("result=" + (5>>1));
        System.out.println("result=" + (4>>1));
        System.out.println("result=" + (3>>1));

        Vector<String> vector = new Vector<>(16);
        vector.iterator();
    }

    @Test
    public void multiThreadRemove()  {
        for (int i = 0; i < 1000; i++) {
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
        }

        Thread thread1 = new Thread(() -> {
            Iterator<Integer> iterator = list.iterator();
            while(iterator.hasNext()){
//                Integer integer = iterator.next();
//                System.out.println(integer);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
//        Thread thread2 = new Thread(() -> {
//            Iterator<Integer> iterator = list.iterator();
//            while(iterator.hasNext()){
//                Integer integer = iterator.next();
//                if(integer==2) {
//                    iterator.remove();
//                }
//            }
//        });

        Thread thread2 = new Thread(() -> {
            Iterator<Integer> iterator = list.iterator();
            while(iterator.hasNext()){
                Integer integer = iterator.next();
                if(integer==2) {
//                    iterator.remove();
                    list.remove(integer);
                }
            }
        });

        thread1.start();
        System.out.println("list=" + list);
        thread2.start();
        System.out.println("list=" + list);
    }

    @Test
    public void realDangerous()  {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==2) {
                list.remove(integer);
            }
        }
    }

    @Test
    public void safeRemove() {
//        for (int i=0; i<10000; i++) {
//            List<String> list1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5");

        Iterator<String> iterator = list1.iterator();
        while(iterator.hasNext()) {
            String ele = iterator.next();
            if ("1".equals(ele)) {
                iterator.remove();
//                list1.remove(ele);
            }
        }
        System.out.println("list1=" + list1);

        for(String ele : list1) {
            if ("2".equals(ele)) {
               list1.remove(ele);
            }
        }

        System.out.println("list1=" + list1);

//        ArrayList list = new ArrayList<>();
//        list.iterator();
//        }
    }

    @Test
    public void dangerousRemove() {
//        List<String> list1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
//        for (String ele : list1) {
//            if ("3".equals(ele)) {
//                list1.remove(ele);
//            }
//        }
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        for (int i = 0; i < list1.size(); i++) {
            String ele = list1.get(i);
            if ("3".equals(ele)) {
                list1.remove(ele);
            }
        }
        System.out.println("list1=" + list1);
    }

    @Test
    public void testReplaceFirst() {
        List<String> list1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        list1.remove(0);
        list1.add(0, "9999");
        System.out.println("list1=" + list1);
        Optional<String> value = list1.stream().filter(e -> e.equals("999")).findFirst();
        System.out.println("result=" + value.isPresent());

    }

    @Test
    public void removeAll() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> list2 = Arrays.asList(1, 2, 7);
        System.out.println("list1=" + list1);
        list1.removeAll(list2);
        System.out.println("result=" + list1);
    }

    @Test
    public void testLinkList() {
        // 双向非循环列表
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.remove(2);
        linkedList.getFirst();
    }

    @Test
    public void retailAll() {
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);

//        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        // 调用retailAll方法会抛异常，因为asList返回的类，没有实现retailAll方法，调用的是是其父类方法， 其父类直接跑出unsupported异常了

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(4);
        list2.add(5);

        list1.retainAll(list2);
        System.out.println("list1="+list1);
    }

    @Test
    public void ss() {
        List<Father> fatherList = new ArrayList<>();
        fatherList.add(new SonA());
        fatherList.add(new SonB());
        fatherList.add(new Father());
        System.out.println("fatherList=" + fatherList);
    }

    @Test
    public void add2First() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        System.out.println("list=" + list);
        list.add(0, 1);
        list.add(0, 2);
        System.out.println("list=" + list);
    }

    @Test
    public void shuffle() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        System.out.println("list1=" + list);
        Collections.shuffle(list);
        System.out.println("list2=" + list);
    }


}

class Father {

}

class SonA extends Father {

}

class SonB extends Father {

}

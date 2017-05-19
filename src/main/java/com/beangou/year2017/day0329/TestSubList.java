package com.beangou.year2017.day0329;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/3/29
 * @since 1.0
 */
public class TestSubList {

    @Test
    public void subList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("111111" + i);
        }


        List<String> list2 = list.subList(0, 20);
        System.out.println("list=" + list);
        System.out.println("list2=" + list2);

        System.out.println("submitList=" + list.removeAll(list2));
        System.out.println("result=" + list);

//        List<String> secondeList = null;
//        list2.addAll(secondeList);
    }

}

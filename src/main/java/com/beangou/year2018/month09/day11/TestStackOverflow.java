package com.beangou.year2018.month09.day11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小彬
 * @version V1.0 2018/9/11 上午11:38
 * @since V1.0
 */
public class TestStackOverflow {

    List<int[]> list = new ArrayList<>();

    @Test
    public void outOfMemory() {
        while (true) {
            System.out.println("add one");
            list.add(new int[1024]);
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void overflow() {
        haha(5);
    }

    public int haha(int i) {
        return i + haha(i);
    }

}

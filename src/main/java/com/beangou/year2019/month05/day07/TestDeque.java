package com.beangou.year2019.month05.day07;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 小彬
 * @version V1.0 2019-05-07 16:37
 * @since V1.0
 */
public class TestDeque {

    @Test
    public void likeQueue() {
        Deque deque = new LinkedList();
        deque.addFirst("a");
        Object obj = deque.pollLast();

    }

}

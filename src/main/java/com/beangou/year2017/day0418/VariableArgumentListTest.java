package com.beangou.year2017.day0418;

import org.junit.Test;

/**
 * Created by liutongbin on 2017/4/18.
 */
public class VariableArgumentListTest {

    @Test
    public void see() {
        aa(new Object[] {});
    }

    public void aa(Object[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("ele=" + args[i]);
        }
    }

}

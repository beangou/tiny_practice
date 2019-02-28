package com.beangou.year2018.month12;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author 小彬
 * @version V1.0 2018-12-05 10:57
 * @since V1.0
 */
public class TestFor {

    @Test
    public void myForeach() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.forEach( e-> {
            if (e > 2) {
                System.out.println("e=" + e);
            } else {
                return;
            }
        });
    }

}

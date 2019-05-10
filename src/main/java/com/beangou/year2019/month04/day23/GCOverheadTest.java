package com.beangou.year2019.month04.day23;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小彬
 * @version V1.0 2019-04-23 23:03
 * @since V1.0
 */
public class GCOverheadTest {

    @Test
    public void gcOverhead() {
        int i = 0;
        List<String> list = new ArrayList<>();
        // swallow
        while (true) {
            list.add(String.valueOf(++i).intern());
        }
    }

}

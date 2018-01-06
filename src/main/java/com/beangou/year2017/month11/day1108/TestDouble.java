package com.beangou.year2017.month11.day1108;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.text.DecimalFormat;

/**
 * @author 小彬
 * @version V1.0 2017/11/8 下午5:53
 * @since V1.0
 */
public class TestDouble {

    @Test
    public void divide() {
        long a = 5;
        long b = 3;

        double averagePvNum = (double) a/b;
        System.out.println(""+a/b+"  " + averagePvNum);

        DecimalFormat df = new DecimalFormat("0.0");
        System.out.println(df.format(averagePvNum));
        System.out.println(NumberUtils.createDouble(df.format(averagePvNum)));

        System.out.println(String.format("%.1f", (double)5/3));

    }

}

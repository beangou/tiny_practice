package com.beangou.year2019.month03.day14;

import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * @author 小彬
 * @version V1.0 2019-03-14 15:39
 * @since V1.0
 */
public class StringTest {

    @Test
    public void printArr() {
        String[] aa = new String[]{"111", "2222"};
        System.out.println("aa=" + aa + "sss=" + Arrays.toString(aa));
    }

    @Test
    public void replace() {
        System.out.println("https://www.facebook.com/232xxxx".replace("https://www.facebook.com/", ""));

        try {
            int a = 99/0;
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String msg=sw.toString();

            System.out.println("exception=" + msg);
        }
    }

}

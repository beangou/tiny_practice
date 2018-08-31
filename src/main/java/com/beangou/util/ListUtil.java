package com.beangou.util;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author 小彬
 * @version V1.0 2018/2/8 下午1:34
 * @since V1.0
 */
public class ListUtil {

    public static String[] list2StringArr(List<String> list) {
        String[] arr = new String[list.size()];
        list.toArray(arr);
        System.out.println("arr=" + arr[1]);
        return arr;
    }

    /**
     * list 转 字符串，以指定分隔符分开
     * @param list
     * @return
     */
    public static String list2String(List<String> list, String separator) {
        return StringUtils.join(list.toArray(), separator);
    }

    /**
     * 字符串转list，字符串以指定字符分开
     * @param str
     * @param separator
     * @return
     */
    public static List<String> string2List(String str, String separator) {
        return Arrays.asList(StringUtils.split(str, separator));
    }

    @Test
    public void see() {

        System.out.println("result=" + list2StringArr(Arrays.asList("1111", "555", "000")).length);

        String[] aa = "11,22,33,44,55".split(",");
        List<String> list = Arrays.asList(aa);
        System.out.println("ss=" + list.size());

    }

}

package com.beangou.year2017.month04.day0429;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by liutongbin on 2017/4/29.
 */
public class PPrint {

    public static void pPrint(Object[] arr) {
        System.out.println(Arrays.asList(arr));
    }

    public static void pPrint(Collection<?> collection) {
        System.out.println(pFormat(collection));
    }

    public static String pFormat(Collection<?> collection) {
        if (collection.size() == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (Object item : collection) {
            if (collection.size() != 1) {
                sb.append("\n ");
            }
            sb.append(item);
        }
        if (collection.size() != 1) {
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

}

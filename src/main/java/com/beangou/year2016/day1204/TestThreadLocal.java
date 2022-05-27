package com.beangou.year2016.day1204;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

/**
 * Created by liutb on 2016/12/4.
 *
 * @since 1.0.0
 */
public class TestThreadLocal {
    public static void main(String[] args) {
//        ThreadLocal<Object> objectThreadLocal = ThreadLocal.withInitial();
//        objectThreadLocal.get();
        ThreadLocal<SimpleDateFormat> local = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
        System.out.println(local.get().format(new Date()));

        System.out.println("local=" + local.get());
        local.set(null);
        System.out.println("local=" + local.get());

        local.remove();
        if(local == null) {
            System.out.println("");
        } else {
            System.out.println(33);
        }

        Hashtable table = null;
    }
}



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

        if(local == null) {
            System.out.println("");
        } else {
            System.out.println(33);
        }

        Hashtable table = null;

        ThreadLocal local1 = new ThreadLocal() {
            @Override
            protected Object initialValue() {
                System.out.println("comes...");
                return new Object();
            }
        };

        Object obj2 = local1.get();
        Object obj = new Object();
        System.out.println("obj=" + obj);
        local1.set(obj);
        System.out.println("local.get="+local1.get());

    }
}



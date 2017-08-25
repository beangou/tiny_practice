package com.beangou.year2017.month08.day23;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liutongbin on 2017/8/23.
 */
public class TesetDate {

    @Test
    public void time() throws ParseException {
        // 调用new Date(long)方法，910会被忽略掉
        System.out.println("result=" + new Date(1500963112910L));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse("2017-07-25 14:11:51");
        System.out.println("result=" + date.getTime());
        date.hashCode();

        Map map = new HashMap();
        map.keySet().iterator();

        // 1500963110000  1500963110010
    }

}

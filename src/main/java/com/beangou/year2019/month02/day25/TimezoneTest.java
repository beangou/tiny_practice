package com.beangou.year2019.month02.day25;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author 小彬
 * @version V1.0 2019-02-25 11:20
 * @since V1.0
 */
public class TimezoneTest {

    @Test
    public void see() throws ParseException {
        //时间格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //根据入参原时区id，获取对应的timezone对象
        TimeZone sourceTimeZone = TimeZone.getTimeZone("GMT+08:00");
        //设置SimpleDateFormat时区为原时区（否则是本地默认时区），目的:用来将字符串sourceTime转化成原时区对应的date对象
        df.setTimeZone(sourceTimeZone);
        //将字符串sourceTime转化成原时区对应的date对象
        Date sourceDate = df.parse("2019-02-25 01:31:26");
        System.out.println(sourceDate);
    }

}

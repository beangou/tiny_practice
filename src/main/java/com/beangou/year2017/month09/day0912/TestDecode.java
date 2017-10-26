package com.beangou.year2017.month09.day0912;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Created by liutongbin on 2017/9/12.
 */
public class TestDecode {

    @Test
    public void tet() throws UnsupportedEncodingException {
        System.out.println(new String("\u65e5\u672c".getBytes(), "utf-8"));

        String result = "{\"code\":0,\"data\":{\"country\":\"\\u65e5\\u672c\",\"country_id\":\"JP\",\"area\":\"\",\"area_id\":\"-1\",\"region\":\"\",\"region_id\":\"-1\",\"city\":\"\",\"city_id\":\"-1\",\"county\":\"\",\"county_id\":\"-1\",\"isp\":\"choopa\",\"isp_id\":\"-1\",\"ip\":\"45.77.28.102\"}}";

        System.out.println(new String(result.getBytes(), "utf-8"));
    }

}

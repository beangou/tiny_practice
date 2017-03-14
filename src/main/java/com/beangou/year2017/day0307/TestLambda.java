package com.beangou.year2017.day0307;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/3/7
 * @since 1.0
 */
public class TestLambda {

    @Test
    public void testMap() {
        String idsStr = "22,22,221,123,323";
        String[] idArr = idsStr.split(",");
        List<Long> idList = Arrays.stream(idArr).map(e -> Long.valueOf(e)).collect(Collectors.toList());
        System.out.println("idList=" + idList);
    }

}

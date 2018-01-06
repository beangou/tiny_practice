package com.beangou.util.httpclient;

import com.alibaba.fastjson.TypeReference;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;

import javax.net.ssl.SSLException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author 小彬
 * @version V1.0 2017/12/22 下午4:52
 * @since V1.0
 */
public class HttpClientUtilTest {

    @Test
    public void testGet() {
        List nonRetryClassList = Arrays.asList(
                UnknownHostException.class,
                SSLException.class);
        HttpClientUtil util = new HttpClientUtil(1000, 8000, 100, 1, 0, nonRetryClassList);
        HttpClientUtil util2 = new HttpClientUtil();
        String uri = "http://localhost:8080/controller/httpclient/test";
        Map<String, Object> params = new HashedMap(2);

//        for (int i = 0; i < 2; i++) {
//            new Thread(() -> {
                while (true) {
                    long startTime = 0;
                    try {
                        startTime = System.currentTimeMillis();
                        System.out.print("result=" + util2.get(uri, params, new TypeReference<String>() {
                        }));
                    } catch (Exception e) {
                        System.out.println("error during time = " + (System.currentTimeMillis() - startTime) / 1000);
                        e.printStackTrace();
                    }
                    System.out.println("during time = " + (System.currentTimeMillis() - startTime) / 1000);
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//            }).start();
//        }
//
//        try {
//            Thread.sleep(100000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}

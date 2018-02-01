package com.beangou.util.httpclient;

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

    public static void main(String[] args) {
        System.out.println("see.");
        new HttpClientUtilTest().testGet();
    }

    @Test
    public void see() {
        System.out.println("see.");
    }

    @Test
    public void testGet() {
//        List nonRetryClassList = Arrays.asList(
//                UnknownHostException.class,
//                SSLException.class);
//        HttpClientUtil util = new HttpClientUtil(1000, 8000, 100, 1, 0, nonRetryClassList);
        HttpClientUtil util2 = new HttpClientUtil();
//        String uri = "http://localhost:8080/controller/httpclient/test";
//        String uri = "https://s.taobao.com/search?q=%E9%87%8D%E6%9C%BA&imgfile=&js=1&stats_click=search_radio_tmall%3A1&initiative_id=staobaoz_20180116&tab=mall&cd=false&ie=utf8&bcoffset=0&p4ppushleft=%2C44&&s=0";
        String[] arr = {"生鲜", "衡水老白干", "鞋", "袜子", "电脑", "重机", "pc", "屏幕", "坚果", "笔记本", "图纸"};
        Map<String, Object> params = new HashedMap(2);

//        for (int i = 0; i < 2; i++) {
//            new Thread(() -> {
        int tryCount = 0;
        boolean continueTry = false;
        int successCount = 0;
        String keywords = null;
                while (true) {
                    tryCount++;
                    long startTime = 0;
                    if (!continueTry) {
                        keywords = arr[(int)(Math.random()*9)];
                    }
                    try {
                        startTime = System.currentTimeMillis();
//                        String uri = "https://s.taobao.com/search?q="+keywords+"&imgfile=&js=1&stats_click=search_radio_tmall%3A1&initiative_id=staobaoz_20180116&tab=mall&cd=false&ie=utf8&bcoffset=0&p4ppushleft=%2C44&&s=0";
                        String uri = "https://s.taobao.com/search?q="+keywords+"&imgfile=&js=1&stats_click=search_radio_all%3A1&initiative_id=staobaoz_20180117&ie=utf8&bcoffset=4&ntoffset=4&p4ppushleft=2%2C48&s=0";
                        String result = util2.get(uri);
                        if (result != null) {
                            successCount++;
                            continueTry = false;
                        } else {
                            continueTry = true;
                        }
                    } catch (Exception e) {
                        continueTry = true;
                        System.out.println("error during time = " + (System.currentTimeMillis() - startTime) / 1000);
                        e.printStackTrace();
                    }
                    System.out.println("成功:"+successCount+", 总数="+tryCount+",keywords="+keywords);
//                    System.out.println("during time = " + (System.currentTimeMillis() - startTime) / 1000);
                    try {
//                        Thread.sleep(2000+(int)(2000L*Math.random()));
                        Thread.sleep(1000);
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

package com.beangou.year2017;

import lombok.Builder;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.concurrent.Callable;

/**
 * Created by liutongbin on 2017/10/11.
 */
public class TestUrl {

    @Test
    public void encode() {

        Callable<Object> callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return new Object();
            }
        };
    }

    @Test
    public void decode() throws UnsupportedEncodingException {
        String url = "http%3A%2F%2Fnba.bluewebgame.com%2Foauth_response.php";
        System.out.println("result=" + URLDecoder.decode(url, "utf8"));

        String url2 = "http://www.beangou.com/wx";
        System.out.println("result=" + URLEncoder.encode(url2, "utf8"));
    }

}

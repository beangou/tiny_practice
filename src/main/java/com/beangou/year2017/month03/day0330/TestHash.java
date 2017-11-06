package com.beangou.year2017.month03.day0330;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by liutongbin on 2017/3/30.
 */
public class TestHash {

    @Test
    public void hash() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest("SolrRocks".getBytes("UTF-8"));
        System.out.println("hash=" + hash);
        for (int i = 0; i < hash.length; i++) {
            System.out.print(hash[i]);
        }
    }

}

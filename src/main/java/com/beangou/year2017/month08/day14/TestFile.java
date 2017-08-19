package com.beangou.year2017.month08.day14;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

/**
 * Created by liutongbin on 2017/8/14.
 */
public class TestFile {

    @Test
    public void readProperties() throws IOException {
        Properties properties = new Properties();
//        properties.load(new FileInputStream("/Users/liutongbin/IdeaProjects/tiny_practice/src/main/resources/config.properties"));
//        properties.load(new FileInputStream("src/main/resources/config.properties"));
//        properties.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));

        InputStream in = new BufferedInputStream(new FileInputStream("src/main/resources/config.properties"));
        properties.load(in);
        System.out.println("name=" + properties.getProperty("name"));
    }

}

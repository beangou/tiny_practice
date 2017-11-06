package com.beangou.year2017.month04.day0429;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by liutongbin on 2017/4/29.
 */
public class MyIO {

    @Test
    public void createFile() {
//        File file = new File("/Users/liutongbin/IdeaProjects/testBasic");
//        if (!file.exists()) {
//            file.mkdir();
//        }

//        File file = new File("/Users/liutongbin/IdeaProjects/testBasicee.java");
//        File file = new File("src/main/java/com/beangou/year2017/day0429/MyIO.java");
        File file = new File("/Users/liutongbin/Downloads/solr-6.4.2.zip");
        System.out.println("isExist=" + file.exists());
        System.out.println("length =" + (float)file.length()/1024/1024);
    }

    @Test
    public void testFile() {
        File file = new File("src/main/java/com/beangou/year2017/day0429");

        for (String fileName :file.list()) {
            System.out.println("name=" + fileName);
        }

        System.out.println("isdir?=" + file.isDirectory() + ", isFile=" + file.isFile());

        String[] fileNames = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                System.out.println("name=" + name);
                return false;
            }
        });

        System.out.println("getFreeSpace()=" + (file.getFreeSpace())/1024/1024/1024);
        System.out.println("file.getTotalSpace()=" + (file.getTotalSpace())/1024/1024/1024);

        System.out.println("next...");
        for (String name : fileNames) {
            System.out.println("list2=" + name);
        }

    }

}

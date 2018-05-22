package com.beangou.util;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 小彬
 * @version V1.0 2018/3/9 下午12:57
 * @since V1.0
 */
public class FileUtil {

    @Test
    public void saveFileFromUrl() throws IOException {
        FileUtils.copyURLToFile(new URL("https://img.onloon.co/product/20170413142147397023830.jpg"), new File("hahah.jpg"));
    }

}

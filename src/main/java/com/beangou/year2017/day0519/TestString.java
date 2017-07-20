package com.beangou.year2017.day0519;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/5/19
 * @since 1.0
 */
public class TestString {

    @Test
    public void trim() {
        System.out.println("result=" + "     ".trim() + "******");
        System.out.println("result=" + "  ss   ".trim() + "******");
        System.out.println("result=" + "  d d  ".trim() + "******");
        System.out.println("result=" + "  dd  ss ".trim() + "******");
        System.out.println("result=" + "  ss   ".trim() + "******");

        System.out.println(StringUtils.isBlank(""));
        System.out.println(StringUtils.isBlank("  "));
        System.out.println(StringUtils.isBlank("ss "));
        System.out.println(StringUtils.isBlank("ss  "));

        System.out.println("result=" + "https://buyer.onloon.com.cn/detail?shopId=151623511167744942&productId=ef7ccec260e64ac9be7c73094b6bfdd0".replace("productId=ef7ccec260e64ac9be7c73094b6bfdd0", "productId=ef7ccec260e64ac9be7c73094b6bfdd0&viewFrom=1"));
    }

}

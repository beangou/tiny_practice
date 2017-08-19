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

//        String str1 = "{\"originData\":{\"state\":\"\",\"city\":\"\",\"address\":\"San Francisco Bay Area\",\"postcode\":\"\"},\"newData\":{\"state\":\"CA\",\"city\":\"Oakland\",\"address\":\"300 Lakeside Dr\",\"postcode\":\"94604\"},\"toUpdateFields\":\"地区，城市，street address，邮编，\",\"updatedFields\":\"头像，公司主页，联系电话，行业，员工数量，facebook主页，\"}";
//        String str2 = "{\"originData\":{\"state\":\"\",\"city\":\"\",\"address\":\"San Francisco Bay Area\",\"postcode\":\"\"},\"newData\":{\"state\":\"CA\",\"city\":\"Oakland\",\"address\":\"300 Lakeside Dr\",\"postcode\":\"94604\"},\"toUpdateFields\":\"地区，城市，street address，邮编，\",\"updatedFields\":\"\"}";

        System.out.println("result=" + "     ".trim() + "******");
        System.out.println("result=" + "  ss   ".trim() + "******");
        System.out.println("result=" + "  d d  ".trim() + "******");
        System.out.println("result=" + "  dd  ss ".trim() + "******");
        System.out.println("result=" + "  ss   ".trim() + "******");

        System.out.println(StringUtils.isBlank(""));
        System.out.println(StringUtils.isBlank("  "));
        System.out.println(StringUtils.isBlank("ss "));
        System.out.println(StringUtils.isBlank("ss  "));

//        System.out.println("result=" + "https://buyer.onloon.com.cn/detail?shopId=151623511167744942&productId=ef7ccec260e64ac9be7c73094b6bfdd0".replace("productId=ef7ccec260e64ac9be7c73094b6bfdd0", "productId=ef7ccec260e64ac9be7c73094b6bfdd0&viewFrom=1"));
    }

}

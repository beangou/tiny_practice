package com.beangou.year2017.month05.day0519;

import org.apache.commons.lang3.StringUtils;
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
 * @version 1.0 2017/5/19
 * @since 1.0
 */
public class TestString {

    @Test
    public void plus() {
        String a = "test2";
        String b = "test"+2;

        String[] split = a.split("");

        for (int i = 0; i < split.length; i++) {
            System.out.println("sss=" + split[i]);
        }

        System.out.println("aa=" + split);

        System.out.println(a==b);
    }

    @Test
    public void unmodified() {
        String str1 = "abcde";
        str1.intern();
        String str2 = str1;
        str1 = "dddd";
        System.out.println(str1);
        System.out.println(str2);
    }

    @Test
    public void splitAndTrim() {
        String str = "ss kkk   ddsd ds  dds kk   ";
        String[] strArr = str.split(" ");
        for (String e : strArr) {
            if ("".equals(e)) {
                continue;
            }
            System.out.println("start=" + e + "=end");
        }
    }

    @Test
    public void valueOf() {

        String title = "Caroline Kaam Harris | Professional Profile - LinkedIn";
        System.out.println("contains | =" + title.contains(" | "));
        String name = title.split(" \\|")[0];
        System.out.println("name=" + name + "ssss");
        int lastIndex = name.lastIndexOf(" ");

        String firstName = name.substring(0, lastIndex);
        String lastName = name.substring(lastIndex+1);
        System.out.println("firstname=" + firstName + "; lastname=" + lastName);
        System.out.println("sss=" + String.valueOf(""+null));
    }

    @Test
    public void trim() {

        List<String> list = Arrays.asList("111", "222", "333", "111", "333");
        System.out.println("set=" + list.stream().map(e -> e).collect(Collectors.toSet()));

//        String str1 = "{\"originData\":{\"state\":\"\",\"city\":\"\",\"address\":\"San Francisco Bay Area\",\"postcode\":\"\"},\"newData\":{\"state\":\"CA\",\"city\":\"Oakland\",\"address\":\"300 Lakeside Dr\",\"postcode\":\"94604\"},\"toUpdateFields\":\"地区，城市，street address，邮编，\",\"updatedFields\":\"头像，公司主页，联系电话，行业，员工数量，facebook主页，\"}";
//        String str2 = "{\"originData\":{\"state\":\"\",\"city\":\"\",\"address\":\"San Francisco Bay Area\",\"postcode\":\"\"},\"newData\":{\"state\":\"CA\",\"city\":\"Oakland\",\"address\":\"300 Lakeside Dr\",\"postcode\":\"94604\"},\"toUpdateFields\":\"地区，城市，street address，邮编，\",\"updatedFields\":\"\"}";

        String str = "http://www.usaimportdata.com/usa-import-p-ibm55_888888-ct-CHINA.aspx?taskId=222289893";
        int startIndex = str.indexOf("usa-import-p-");
        int endIndex = str.indexOf("-ct-CHINA.aspx");
        System.out.println("result=" + str.substring(startIndex+"usa-import-p-".length(), endIndex).replaceAll("_", " "));

        String targetUrl = "default.cgi/action/viewtradeleads/tradeleadid/551183/subject/International_Purchase_Of_Goods/";
        int idStart = targetUrl.indexOf("tradeleadid/")+"tradeleadid/".length();
        int idEnd = targetUrl.indexOf("/subject");
        String id = targetUrl.substring(idStart, idEnd);
        System.out.println("id=" + id);

        String detailInfo = "Posted on: 2017-09-11 from UK - South East of England";
        int timeStartIndex = detailInfo.indexOf("Posted on: ");
        int timeEndIndex = detailInfo.indexOf(" from ");

//        System.out.println("result=" + detailInfo.substring(timeStartIndex + "Posted on: ".length(), timeEndIndex) +"====");
        String enquiryDateStr = detailInfo.substring(timeStartIndex + "Posted on: ".length(), timeEndIndex);

        System.out.println("detailAddr = " + detailInfo.replace("Posted on: "+enquiryDateStr+" from "+"UK"+" - ", ""));

        System.out.println("old value=" + detailInfo);

        String a = null;
        System.out.println("ddd"+a);

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

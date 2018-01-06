package com.beangou.year2017.month11.day1126;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小彬
 * @version V1.0 2017/11/26 下午1:33
 * @since V1.0
 */
public class TestEqual {

    @Test
    public void testListContains() throws InterruptedException {
        String a = "fish";
        CaseInsensitiveString caseInsensitiveString = new CaseInsensitiveString("Fish");
        CaseInsensitiveString caseInsensitiveString2 = new CaseInsensitiveString("Fish");
        System.out.println("result1=" + (caseInsensitiveString.equals(a)));
        System.out.println("result1=" + (a.equals(caseInsensitiveString)));

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(caseInsensitiveString);
        System.out.println("list contains=" + list.contains(caseInsensitiveString2));

    }

}

final class CaseInsensitiveString {

    public String str;

//    public CaseInsensitiveString (String str) {
    public CaseInsensitiveString (String str) throws InterruptedException {
        this.wait();
        if (str == null) {
            throw new NullPointerException();
        }
        this.str = str;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof String) {
            return str.equalsIgnoreCase(obj.toString());
        } else if (obj instanceof CaseInsensitiveString) {
            System.out.println("call equals method");
            return str.equalsIgnoreCase(((CaseInsensitiveString)obj).str);
        }
        return false;
//        if (obj == null || !(obj instanceof CaseInsensitiveString)) {
//            return false;
//        }

    }

}



package com.beangou.year2017.month08.day29;

import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/8/29
 * @since 1.0
 */
public class TestSet {

    @Test
    public void add() {

        System.out.println("result= " + new Date(1504348409796L));

        Set<String> set = new HashSet<>();
        set.add("111");
        set.add(null);
        set.add("222");
        set.add("111");
        System.out.println("set=" + set);

        System.out.println("res=" + 365 * 24 * 60 * 60);
    }

    @Test
    public void seeTreeSet() {
        TreeSet<Integer> set = new TreeSet();
        set.add(999);
    }

}

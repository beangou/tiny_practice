package com.beangou.year2017.month06.day0623;

import com.beangou.year2017.Entity;
import lombok.Data;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/6/23
 * @since 1.0
 */
public class TestArray {

    @Test
    public void size() {
        String[] strArr = new String[10];
        strArr[0] = "0";
        strArr[1] = "1";
        strArr[2] = "2";
        strArr[3] = "3";
        System.out.println("len=" + strArr.length);
    }

    @Test
    public void genericArr() {
        Person[] peopleArr = newArray(Person.class, 5);
        for (int i = 0; i < peopleArr.length; i++) {
            System.out.println("result=" + peopleArr[i]);
        }
    }

    private <T> T[] newArray(Class<T> t, int size) {
        return (T[])Array.newInstance(t, size);
    }

    @Test
    public void initArr() {

        Integer[] uidArr = new Integer[]{};

        List<Integer> result = Arrays.asList(uidArr);
        System.out.println("result.size=" + result.size());

        for (int i = 0; i < uidArr.length; i++) {
            if (i < 960 && uidArr[i] - uidArr[i+1] > 1) {
                System.out.println("" + uidArr[i] + " to " + uidArr[i+1]);
            }
        }

        System.out.println("sss=" + Integer.MAX_VALUE);


        Object[] objArr = {"111", "222", "3333"};

        System.out.println("list=" + Arrays.asList(objArr).size());

        Object[] objs = {new Object(), new Object()};

        Integer[][] objects = new Integer[5][3];

        System.out.println("result=" + 1000 * 60 * 60 * 24);

        System.out.println("date=" + new Date(System.currentTimeMillis() - 1000L * 60 * 60 * 24 * 30));

//        for ()

//        compile error.
//        Object[] objs2;
//        objs2 = {new Object(), new Object()};
    }

}

@Data
class Person extends Entity {
    private String name;

    private int age;
}
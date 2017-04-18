package com.beangou.year2017.day0418;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/4/18
 * @since 1.0
 */

public class ListTest {

    @Test
    public void ss() {
        List<Father> fatherList = new ArrayList<>();
        fatherList.add(new SonA());
        fatherList.add(new SonB());
        fatherList.add(new Father());
        System.out.println("fatherList=" + fatherList);
    }


}

class Father {

}

class SonA extends Father {

}

class SonB extends Father {

}

package com.beangou.year2017.month12.day26;

import org.junit.Test;

/**
 * @author 小彬
 * @version V1.0 2017/12/26 上午7:45
 * @since V1.0
 */
public class TestSafePublish {

    @Test
    public void see() {
        Holder holder = new Holder(88);
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                holder.haveALook();
            }).start();
        }
    }

}

class Holder {

    private int n;

    public Holder(int n) {
        this.n = n;
    }

    public void haveALook() {
        assert n != n : "not safe published";
    }

}

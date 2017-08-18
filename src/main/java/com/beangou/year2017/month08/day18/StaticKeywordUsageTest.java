package com.beangou.year2017.month08.day18;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/8/18
 * @since 1.0
 */
public class StaticKeywordUsageTest {

}

class Usage1 {
    public static class InnerStaticSimpleDateFormat implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(3000);
                    try {
                        System.out.println("thread=" + Thread.currentThread().getName() + "result=" + DateUtil.parse2Date("2017-07-27 08:02:20"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args) {
            for (int i = 0; i < 3; i++) {
                new Thread(new InnerStaticSimpleDateFormat(), "线程测试"+i).start();
            }
        }
    }
}


class DateUtil {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatFromDate(Date date) {
        return simpleDateFormat.format(date);
    }

    public static Date parse2Date(String dateStr) throws ParseException {
        return simpleDateFormat.parse(dateStr);
    }
}
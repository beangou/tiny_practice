package com.beangou.year2017.day0628;

import org.junit.Test;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/6/28
 * @since 1.0
 */
public class TestTimeStamp {

    // Unix时间戳不仅被使用在Unix系统、类Unix系统中，也在许多其他操作系统中被广泛采用。
    // 但是，这并不意味着目前的时间戳规范会一直持续使用下去。因为到2038年1月19日时，
    // Unix时间戳就会因为32位内存溢出（32-bit overflow）而无法继续使用。
    // 因此，在这一天之前，上千万的网络应用要么采用新的时间戳规范，要么迁移到64位系统，后者可以给时间戳争取“一点”时间。
    @Test
    public void test() {
        System.out.println("a1=" + System.currentTimeMillis());
    }

}

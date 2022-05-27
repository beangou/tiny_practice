package com.beangou.year2017.month03.day0309;

import org.junit.Test;

import java.lang.ref.*;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/3/9
 * @since 1.0
 */
public class TestReference {

    @Test
    public void pass() {
        String aa = "nba";
        changeAa(aa);
        System.out.println(aa);
    }

    private void changeAa(String aa) {
        aa = "cba";
    }

    @Test
    public void test() {
        boolean primitiveType = false;
        Boolean referenceType = false;
    }

    @Test
    public void softReference() {
        SoftReference<String> softReference = new SoftReference("33333");
        System.out.println(softReference.get());
        System.gc();
        System.out.println(softReference.get());
//        Reference
    }

    @Test
    public void weakReference() {
        WeakReference<String> weakReference = new WeakReference("3333");
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());
    }

    @Test
    public void phantomReference() throws InterruptedException {
        String aa = "aaaa";
        ReferenceQueue referenceQueue = new ReferenceQueue<>();
        PhantomReference<String> reference = new PhantomReference<>(aa, referenceQueue);
//        reference.

        System.gc();

//        Reference pollReference = referenceQueue.poll();
        Reference pollReference = referenceQueue.remove(5000);
        System.out.println("aaa by reference=" + reference.get());
        System.out.println("aaa=" + aa);

//        aa.finalize();

        System.gc();
        System.out.println("aaa222=" + aa);

        System.out.println("reference=" + reference);

        System.out.println("pollReference=" + pollReference);
        System.out.println("pollReference=" + pollReference.get());
    }
}

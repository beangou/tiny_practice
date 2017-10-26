package java.math;

import org.junit.Test;

/**
 * Created by liutongbin on 2017/9/24.
 */
public class BigIntegerTest {



    public BigIntegerTest(String name, int age) {
        System.out.println("init.");
        Thread.currentThread().setContextClassLoader(new ClassLoader() {
        });
    }

    @Test
    public void say () {
      new BigIntegerTest("ss", 22);
    }

}

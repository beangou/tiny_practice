package com.beangou.year2017.month11.day1122;

import com.beangou.year2017.Entity;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

/**
 * @author 小彬
 * @version V1.0 2017/11/22 下午11:36
 * @since V1.0
 */
@Getter
@Setter
abstract class SuperBean extends Entity  {
    private int name;

    private int age;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

@Getter
@Setter
public class TestJavaBean extends SuperBean {


    public static void main(String[] args) {
        TestJavaBean testJavaBean = new TestJavaBean();
        testJavaBean.setAge(18);
        System.out.println("result=" + testJavaBean);
    }
}

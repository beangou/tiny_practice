package com.beangou.year2017.month02.day0203;

import lombok.Getter;

/**
 * Created by liutb on 2017/2/3.
 *
 * @since 1.0.0
 */
public class TestExtends {
    public static void main(String[] args) {
//     MySuper mySuper = new MySub();
//        String str = "000";
//        MySuper mySuper = new MySub("))))");
// 访问不到
//        System.out.println("result=" + new MySub().getSuperA());

        MySuper mySuper = new MySuper();
        mySuper.setB(222);
        MySub mySub = (MySub) mySuper;
        System.out.println("bb=" + mySub.getB());
    }
}
//@Getter
class MySuper {

    static int num = 1;

    private int superA;

    public int b;

    public int getSuperA() {
        return superA;
    }

    public void setSuperA(int superA) {
        this.superA = superA;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    protected MySuper() {
        System.out.println("this is super");
    }
}

@Getter
class MySub extends MySuper {

    static int num = 5;

    public int b;

//    public int getSuperA() {
//        // 访问不到
//        return superA;
//    }

//    private int superA = 9;

    public MySub() {
//        super();
        System.out.println("num=" + num);
        System.out.println("this is sub");
    }

    public MySub(String str) {
        System.out.println(str);
        System.out.println("this is sub2");
    }
}
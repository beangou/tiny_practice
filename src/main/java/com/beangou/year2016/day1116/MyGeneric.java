package com.beangou.year2016.day1116;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by liutb on 2016/11/16.
 *
 * @since 1.0.0
 */
public class MyGeneric<T> {
    private T t;
    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public static void main(String[] args) {
        String[] arr = {"22", "66", "88", "33"};
        System.out.println(MyGenericMethod.getT(4.8, "33", "3.22", 9));
        double aa = MyGenericMethod.getT(4.8, 33., 3.22, 9.);
        System.out.println(MyGenericMethod.getT(arr));
        System.out.println(MyGenericMethod.<String>getT(arr));

        Pair<Employee> pair = new Pair<>();
        Employee e = pair.getFirst();
        Object obj = new HashMap<>();
        Pair<String> pari = (Pair<String>)obj;
//        Pair<String>[] pairs = new Pair<String>[10];  error
        Pair<String>[] pairs = new Pair[10];
        Pair<String>[] pairs2 = (Pair<String>[])new Pair<?>[5];
        pairs[0] = new Pair<String>();
    }
}

class MyGenericMethod {
    public static <T> T getT(T... ts) {
        return ts[ts.length/2];
    }
}

class MyExtends <T extends Comparable & Serializable> {

}

class OtherMyExtends <T extends Serializable & Comparable, dd> {

}

class Employee {

}

class Pair<T> {
    private T first;
    private T second;

//    private static T third; error

    // error
//    private static T getSecond() {
//        return this.second;
//    }

//    @Override
//    public boolean equals(T t) {
//        return true;
//    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
//        first = first;
    }

//    ±¨´í
//    public void setFirst(Object obj) {
//
//    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public static <T extends Comparable> T min(T[] a) {
        T result = a[0];
        for (int i=1; i<a.length; i++) {
            if(result.compareTo(a[i]) > 0) {
                result = a[i];
            }
        }
        return result;
    }
}

class SonPair extends Pair<Date> {
    public void setDate(Date date) {
        if(date.compareTo(super.getFirst()) > 0) {
            super.setSecond(date);
        }
    }

    public Date getSecond() {

        return super.getSecond();
    }

    // Í¨Åä·û
    public Pair<? extends Employee> getT() {
        return new Pair<Employee>();
    }

    void setFirst(Pair<? super Pair> pair) {
    }
}

class Pair2< T extends Employee> {

}


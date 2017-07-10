package com.beangou.year2017.day0701;

import com.beangou.year2017.Entity;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * Created by liutongbin on 2017/7/1.
 */
public class TestConcurrentModificationException {



    @Test
    public void triggerException() {
//        Vector vector = new Vector();
//        vector.iterator();
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Person person = new Person();
            person.setName("p:"+i);
            person.setAge(i);
            personList.add(person);
        }
        System.out.println("before personList=" + personList);
        new Thread(new MyThread(personList)).start();
        Iterator<Person> iterator = personList.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            System.out.println("person=" + person);
            if (person.getAge() > 400) {
                iterator.remove();
            }
        }
//        System.out.println("personList=" + personList);
    }
}


class MyThread implements Runnable {

    private List<Person> personList;

    public MyThread(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public void run() {
        for (Person person : personList) {
            person.setName("ddddd");
            System.out.println("set dddd success"+person.getAge());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println("name=" + person.getName());
        }
    }
}

@Getter
@Setter
class Person extends Entity {
    private String name;
    private int age;
}



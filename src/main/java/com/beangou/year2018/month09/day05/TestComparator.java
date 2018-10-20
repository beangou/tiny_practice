package com.beangou.year2018.month09.day05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 小彬
 * @version V1.0 2018/9/5 下午8:47
 * @since V1.0
 */
public class TestComparator {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person(1);
        Person person2 = new Person(4);
        Person person3 = new Person(2);
        Person person4 = new Person(1);
        Person person5 = new Person(5);
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);

        for (Person person : personList) {
            System.out.println("age=" + person.getAge());
        }

        List<Person> list2 = personList.stream().sorted(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getAge() < o2.getAge()) {
                  return -1;
                } else if (o1.getAge() == o2.getAge()) {
                    return 0;
                }
                return 1;
            }
        }).collect(Collectors.toList());

        for (Person person : list2) {
            System.out.println("age=" + person.getAge());
        }

        System.out.println("********");
        for (Person person : personList) {
            System.out.println("age=" + person.getAge());
        }
    }

}


class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

package com.beangou.year2017.month12.day26;

import com.beangou.year2017.Entity;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 小彬
 * @version V1.0 2017/12/26 下午2:45
 * @since V1.0
 */
public class TestSortList {

    @Test
    public void sort() {
        Person person = new Person(1);
        person.setName("oooo");
        Person person1 = new Person(4);
        person1.setName("hahaha");
        Person person2 = new Person(3);
        Person person3 = new Person(8);
        person3.setName("iii");
        Person person4 = new Person(0);
        List<Person> list = new ArrayList<>();
        list.add(person);
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        System.out.println("list=" + list);
        Collections.sort(list);
        System.out.println("list=" + list);
    }

}

@Getter
@Setter
class Person extends Entity implements Comparable<Person> {

    private int age;

    private String name;

    public Person(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        if (this.age > o.age) {
            return -1;
        } else if (this.age == o.age) {
            return 0;
        } else {
            return 1;
        }
    }
}



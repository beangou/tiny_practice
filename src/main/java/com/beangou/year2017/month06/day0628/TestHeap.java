package com.beangou.year2017.month06.day0628;

import com.beangou.year2017.Entity;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
public class TestHeap {

    @Test
    public void test() {
        // map存储的是person的引用， 堆中存的是对象的引用，而不是实际的对象
        Map<String, Person> map = new HashMap<>();
        Person person = new Person("abc");
        map.put("aaa", person);
        System.out.println("map=" + map);
        Person person1 = map.get("aaa");
        person.setName("bbbb");
        System.out.println("personold=person1:" + (person==person1));
        System.out.println("map=" + map);
    }


}

class Person extends Entity {

    public Person(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
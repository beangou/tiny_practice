package com.beangou.year2018.month12.day22;

import com.beangou.year2017.Entity;
import com.beangou.year2018.month03.day02.PersonForm;
import lombok.*;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 小彬
 * @version V1.0 2018-12-22 13:54
 * @since V1.0
 */
public class TestLombok {



    @Test
    public void print() {

//        Arrays.sort(new int[]{}, 0, 3);

        PersonForm personForm = new PersonForm();

        Object[] objects = new Object[]{new Object(), new Object(), new Object()};
        Arrays.sort(objects);

        System.out.println("result=" + (1/2));
        System.out.println("result=" + (5/2));

//        BufferedReader reader =

        MySonEntity sonEntity = new MySonEntity();
        sonEntity.setAge(22);
        sonEntity.setSubName("bbbba");
        System.out.println("rsult=" + sonEntity.toString());



    }

    @Test
    public void compare() {
        MyEntity entity1 = new MyEntity(111, 0);
        MyEntity entity2 = new MyEntity(22, 0);
        MyEntity entity3 = new MyEntity(25, 1);
        MyEntity entity4 = new MyEntity(1, 0);
        List<MyEntity> entityList = new ArrayList<>();
        entityList.add(entity1);
        entityList.add(entity2);
        entityList.add(entity3);
        entityList.add(entity4);
        List<MyEntity> entityList2 = entityList.stream().sorted((o1, o2) -> o1.getIsPrimary() < o2.getIsPrimary() || (o1.getIsPrimary() == o2.getIsPrimary()&&o1.getAge() < o2.getAge()) ? 1 : -1).collect(Collectors.toList());
        System.out.println("entityList=" + entityList2);
    }

}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class MyEntity extends Entity {
    private int age;
    private int isPrimary;
}

//@Getter
//@Setter
@Data
class MySonEntity extends MyEntity {
    private String subName;
}

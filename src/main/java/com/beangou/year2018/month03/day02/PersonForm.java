package com.beangou.year2018.month03.day02;


import com.beangou.year2017.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author 小彬
 * @version V1.0 2018/3/2 下午10:13
 * @since V1.0
 */
@Getter
@Setter
public class PersonForm extends Entity {
    private String name;
    private int age;
    private List<String> sonList;
    private List<Shoe> shoeList;
}

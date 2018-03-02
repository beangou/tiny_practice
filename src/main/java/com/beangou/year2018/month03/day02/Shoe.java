package com.beangou.year2018.month03.day02;

import com.beangou.year2017.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Shoe extends Entity {
    private String brand;
    private float price;

    public Shoe(String brand, float price) {
        this.brand = brand;
        this.price = price;
    }
}
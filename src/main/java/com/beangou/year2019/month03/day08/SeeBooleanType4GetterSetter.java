package com.beangou.year2019.month03.day08;

import com.alibaba.fastjson.JSON;
import com.beangou.year2017.month08.day04.JsonUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 小彬
 * @version V1.0 2019-03-08 16:55
 * @since V1.0
 */
//@Getter
//@Setter
public class SeeBooleanType4GetterSetter {

//    private boolean ok;
//
//    private Boolean pk;

    private boolean isOk;

    private String hello;

    public boolean isIsOk() {
        return isOk;
    }

    public void setIsOk(boolean isOk) {
        this.isOk = isOk;
    }

//    public Boolean getPk() {
//        return isPk;
//    }
//
//    public void setPk(Boolean pk) {
//        isPk = pk;
//    }

//    private Boolean isPk;



//    public boolean isOk() {
//        return isOk;
//    }
//
//    public void setOk(boolean ok) {
//        isOk = ok;
//    }
//
//    public Boolean getPk() {
//        return isPk;
//    }
//
//    public void setPk(Boolean pk) {
//        isPk = pk;
//    }
//    public boolean isOk() {
//        return ok;
//    }
//
//    public void setOk(boolean ok) {
//        this.ok = ok;
//    }
//
//    public Boolean getPk() {
//        return pk;
//    }
//
//    public void setPk(Boolean pk) {
//        this.pk = pk;
//    }

    public static void main(String[] args) {
        SeeBooleanType4GetterSetter example = new SeeBooleanType4GetterSetter();
//        example.getPk();
//        example.isOk();
        example.setIsOk(true);
//        example.isOk()
//        example.setPk(true);
//        example.setIsPk(true);

//        example.getPk();

//        example.

//        example.getIsPk();


        String eg = JsonUtil.toJsonString(example);
        String eg2 = JSON.toJSONString(example);

        SeeBooleanType4GetterSetter example2 = JsonUtil.fromJsonString(eg, SeeBooleanType4GetterSetter.class);
        SeeBooleanType4GetterSetter example3 = JSON.parseObject(eg, SeeBooleanType4GetterSetter.class);

        System.out.println("result==" + eg);
        System.out.println("fastjson=" + eg2 + ", isOk=" + example3.isIsOk());
        System.out.println("example2.isOk=" + example2.isIsOk());
//        System.out.println("example2.isPk=" + example2.getPk());

//        SeeBooleanType4GetterSetter example3 = JSON.parseObject(eg, SeeBooleanType4GetterSetter.class);
//        System.out.println("example3.isOk=" + example3.isOk());
//        System.out.println("example3.isPk=" + example3.getPk());

    }

}

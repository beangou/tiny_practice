package com.beangou.year2017.month04.day0423;

/**
 * Created by liutongbin on 2017/4/23.
 */
public class PasswordUtils {

    @UseCase(id = 3)
    public String getName() {
        return "beangou";
    }

    @UseCase(id = 4, description = "getAge", useCase2 = @UseCase.UserCase2(id=2, name="222"))
    public int getAge(int age) {
        return age;
    }

    @UseCase(id=2, useCase2=@UseCase.UserCase2(id = 2))
    public String getAddress() {
        return "anqing";
    }

}

package com.beangou.year2017.month12.day11;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.UUID;

/**
 * @author 小彬
 * @version V1.0 2017/12/11 下午7:05
 * @since V1.0
 */
public class DistributeLockByRedis {

    /**
     * redis分布式加锁
     */
    @Test
    public void lock() {
        String b = "333" + null + "9999";
        System.out.println("sss = " + b);

//        RedisT template;
        String aa = "ss ";
        String bb = "ss   ";

        Jedis jedis = new Jedis("localhost");
        String str = jedis.set("myLock2", UUID.randomUUID().toString(), "NX", "EX", 60);
//        jedis.blpop();
//        jedis.zrangeByScore()
//        jedis.z

        System.out.println("result=" + str);
//        jedis.eval();
    }

    @Test
    public void dealStr() {
        System.out.println("result=" + Math.log(Math.E));
        String a = "./company-profile.lakeshore_equipment_company_inc.dfc383b2a4472546.html";
        if (a.indexOf('.') == 0) {
            System.out.println("result= " + a.substring(1, a.length()));
        }
    }


}

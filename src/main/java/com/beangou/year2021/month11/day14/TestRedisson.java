package com.beangou.year2021.month11.day14;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

public class TestRedisson {

    public static void main(String[] args) throws InterruptedException {
        RedissonClient client = redissonClient();
        RLock lock = client.getLock("didddd");
        lock.lock();
        Thread.sleep(20000);
        lock.unlock();
        System.out.println("over");
    }

    @Test
    public void rateLimit() {
        RedissonClient client = redissonClient();
        RRateLimiter limiter = client.getRateLimiter("aaabbc");
        limiter.trySetRate(RateType.OVERALL, 5L, 200L, RateIntervalUnit.SECONDS);

        while (true) {
            System.out.println("aa=" + limiter.tryAcquire(2L));
        }
    }

    public static RedissonClient redissonClient(){
        String redisHost = "localhost";
        int redisPort = 6379;
        String redisPwd = "";
        int redisPoolMinIdle = 3;

        Config config = new Config();
        String add = new StringBuffer("redis://").append(redisHost).append(":").append(redisPort).toString();
        config.useSingleServer().setAddress(add).setConnectionMinimumIdleSize(redisPoolMinIdle);
        RedissonClient client = Redisson.create(config);
//        RLock rLock = client.getLock("ddd");
//        rLock.lock();
        return client;
    }

}

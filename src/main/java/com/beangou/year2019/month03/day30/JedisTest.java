package com.beangou.year2019.month03.day30;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 小彬
 * @version V1.0 2019-03-30 21:49
 * @since V1.0
 */
public class JedisTest {

    @Test
    public void operation() {
        Jedis jedis = new Jedis();
        jedis.spop("");
    }

    class MyLRUCache<K, V> extends LinkedHashMap<K, V> {

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            // 当 map中的数据量大于指定的缓存个数的时候，就自动删除最老的数据。
            return size() > 20;
        }

    }

}

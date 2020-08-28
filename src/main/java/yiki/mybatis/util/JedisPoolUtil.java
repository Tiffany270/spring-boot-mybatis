package yiki.mybatis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

// 双端检索 保证线程不会被篡改
public class JedisPoolUtil {

    private static volatile JedisPool jedisPool = null;
    static String ip = "149.248.19.225";
    static int port = 6379;
    static int timeout = 2000;

    private JedisPoolUtil() {

    }

    public static JedisPool getJedisPoolInstance() {
        if (null == jedisPool) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(1024);
            config.setMaxIdle(100);
            config.setMaxWaitMillis(100);
            config.setTestOnReturn(true);
            jedisPool = new JedisPool(config, ip, port);
        }

        return jedisPool;
    }

    public static void release(Jedis jedis) {
        if (null != jedis) {
            jedis.close();
        }
    }
}

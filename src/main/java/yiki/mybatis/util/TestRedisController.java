package yiki.mybatis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

@ResponseBody
@Controller
@RequestMapping("/redis")
public class TestRedisController {


    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/helloRedis")
    public void helloredis() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        ValueOperations ops = redisTemplate.opsForValue();
//        ops.set("k3", "v3");
        Object k1 = ops.get("A1");
        System.out.println(k1);
    }

    @GetMapping("/testJedis")
    public void cleanRedis() {
        Jedis jedis = new Jedis("149.248.19.225", 6379);
        System.out.println(jedis.ping());
//        jedis.set("k1", "k1");
//        jedis.set("k2", "k2");
//        jedis.set("k3", "k3");
        System.out.println(jedis.keys("*"));

    }

    @GetMapping("/testTxt")
    public void txt() {
        Jedis jedis = new Jedis("149.248.19.225", 6379);
        Transaction transaction = jedis.multi();

        transaction.set("k4", "v4");
        transaction.set("k5", "v5");
        transaction.set("k6", "v6");
        transaction.watch("k6");
        String v = jedis.get("k6");
        if (v.equals("v6")) {
            jedis.unwatch();
            //  do it again
        } else {
            transaction.exec();
        }


        // transaction.discard();// above be discarded

    }

    @GetMapping("/testJedisPool")
    public String testJedisPool() {
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis =null;
        try {
            jedis = jedisPool.getResource();
//            jedis.set("A1","A2");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JedisPoolUtil.release(jedis);

        }

        return jedis.keys("*").toString();

    }


}
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
        Object k1 = ops.get("k2");
        System.out.println(k1);
    }

    @GetMapping("/testJedis")
    public void cleanRedis() {
        Jedis jedis = new Jedis("149.248.19.225",6379);
        System.out.println(jedis.ping());
        jedis.set("k1","k1");
        jedis.set("k2","k2");
        jedis.set("k3","k3");

        System.out.println(jedis.keys("*"));

    }


}
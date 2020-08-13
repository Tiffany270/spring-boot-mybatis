package yiki.mybatis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
@RequestMapping("/redis")
public class TestRedisController {

    /*
    from:string
    to:string
    char_id:from+to
    content:string
    read:boolean
    create_time:date

    * */




    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/helloRedis")
    public void helloredis() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("k2", "v1");
        Object k1 = ops.get("k2");
        System.out.println(k1);
    }
}
package yiki.mybatis.react_app_main;

import com.corundumstudio.socketio.store.pubsub.PubSubListener;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import yiki.mybatis.netty_socketio.Message;
import yiki.mybatis.util.JedisPoolUtil;

@Service
public class ChatService {
     /*
    from:string
    to:string
    char_id:from+to
    content:string
    read:boolean
    create_time:date

    // 干脆直接变成jason算了
    * */

    public void storeMsg(Message message) {
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(message.getChar_id(), message.toString());
            System.out.println(jedis.get(message.getChar_id()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JedisPoolUtil.release(jedis);

        }

    }
}

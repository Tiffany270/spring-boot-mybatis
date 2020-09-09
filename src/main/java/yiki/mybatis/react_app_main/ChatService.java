package yiki.mybatis.react_app_main;

import com.corundumstudio.socketio.store.pubsub.PubSubListener;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import yiki.mybatis.netty_socketio.Message;
import yiki.mybatis.react_app_bean.ChatSchema;
import yiki.mybatis.util.BsonUtil;
import yiki.mybatis.util.JedisPoolUtil;
import yiki.mybatis.util.MongodbUtil;

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

    // redis不适合保存聊天记录，已放弃fine :)
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

    /*   换成mongodb吧
  from:string
  to:string
  char_id:from+to
  content:string
  read:boolean
  create_time:date


  users:{
        "xxxx1":{username:"",header,""},
        "xxxx2":{},
        }
  chatMsg:[{
            read:false,
            id:"xxxxx",
            content:"",
                },{}]

  */
    public void chatSendMsg() {
        MongoDatabase mongoDatabase = MongodbUtil.mongoGetConnect();
        MongoCollection<Document> collection = mongoDatabase.getCollection("test");
//        Document document = new Document();
//        document.append("sex", "男");
//        document .append("age", 18);
//        //插入一个文档
//        collection.insertOne(document);

//        FindIterable findIterable = collection.find();

        // [{from: userid},{to:userid}]
        Bson filter = Filters.eq(
                "sex", "男");
        //指定查询过滤器查询
        FindIterable findIterable = collection.find(filter);

        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }

    }

    public void postMsg(ChatSchema chat) {
        MongoDatabase mongoDatabase = MongodbUtil.mongoGetConnect();
        MongoCollection<Document> collection = mongoDatabase.getCollection("chatList");
        Document document = BsonUtil.toDocument(chat);
        collection.insertOne(document);

        FindIterable findIterable = collection.find();
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

}

package yiki.mybatis.react_app_main;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.corundumstudio.socketio.store.pubsub.PubSubListener;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import yiki.mybatis.netty_socketio.Message;
import yiki.mybatis.react_app_bean.ChatSchema;
import yiki.mybatis.util.BsonUtil;
import yiki.mybatis.util.JedisPoolUtil;
import yiki.mybatis.util.MongodbUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ChatService {


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
        System.out.println(chat.toString());
        Document document = BsonUtil.toDocument(chat);
        collection.insertOne(document);

    }


    public List getRecordsByUserId(String ChatId) {
        MongoDatabase mongoDatabase = MongodbUtil.mongoGetConnect();
        MongoCollection<Document> collection = mongoDatabase.getCollection("chatList");


        String[] chatQuery = ChatId.split("_");
        String chatId1 = chatQuery[0] + "_" + chatQuery[1];
        String chatId2 = chatQuery[1] + "_" + chatQuery[0];
        BasicDBObject queryCondition = new BasicDBObject();
        BasicDBList values = new BasicDBList();
        values.add(new BasicDBObject("chat_id", chatId1));
        values.add(new BasicDBObject("chat_id", chatId2));
        queryCondition.put("$or", values);

        FindIterable findIterable = collection.find(queryCondition);
        MongoCursor cursor = findIterable.iterator();
        ArrayList<Object> res = new ArrayList<>();
        while (cursor.hasNext()) {
            res.add(cursor.next());
        }
        return res;
    }

}

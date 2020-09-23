package yiki.mybatis.util;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongodbUtil {

    public static MongoDatabase mongoGetConnect() {
        //连接到 mongodb 服务
        MongoClient mongoClient = new MongoClient("149.248.19.225", 27117);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("yiki");
        //返回连接数据库对象
        return mongoDatabase;

    }



}

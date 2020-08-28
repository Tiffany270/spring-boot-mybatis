package yiki.mybatis;

import com.corundumstudio.socketio.SocketIOServer;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import yiki.mybatis.util.MongodbUtil;

// 要禁止掉mongo默认的config
@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class SpringBootMybatisApplication {

    @Autowired
    private SocketIOServer socketIOServer;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootMybatisApplication.class, args);


        // ---- IO ---  相关
//        BIOserver.startBIO();
//        NIOserver.scattering_gathering();
//        NIOserver.NIOserve();
//        GroupChatServer.startServer();


        // netty
        //NettyServer.start();//客户端启动在这里面写了
//        NettyHttpSever.start();// use 浏览器：http://localhost:9797/

        //netty-socketio

        MongoDatabase mongoDatabase = MongodbUtil.mongoGetConnect();
        MongoCollection collection = mongoDatabase.getCollection("user");
        System.out.println("test" + collection);

    }




}

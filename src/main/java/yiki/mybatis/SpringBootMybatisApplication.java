package yiki.mybatis;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import yiki.mybatis.netty_learn.basic.NIOserver;
import yiki.mybatis.netty_learn.groupChatSystem.GroupChatServer;
import yiki.mybatis.netty_learn.netty.NettyClient;
import yiki.mybatis.netty_learn.netty.NettyHttpSever;
import yiki.mybatis.netty_learn.netty.NettyServer;
import yiki.mybatis.netty_socketio.Netty_SocketIo_Sever;

@SpringBootApplication
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

    }




}

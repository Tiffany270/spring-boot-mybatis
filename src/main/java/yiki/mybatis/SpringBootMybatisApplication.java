package yiki.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import yiki.mybatis.netty_learn.basic.BIOserver;
import yiki.mybatis.util.NIOserver;

@SpringBootApplication
public class SpringBootMybatisApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootMybatisApplication.class, args);


        // ---- IO ---  相关


//        BIOserver.startBIO();
//        NIOserver.scattering_gathering();
//        NIOserver.NIOserve();


    }

}

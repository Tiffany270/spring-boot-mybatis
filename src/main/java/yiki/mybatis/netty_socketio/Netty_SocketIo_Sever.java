package yiki.mybatis.netty_socketio;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Netty_SocketIo_Sever implements CommandLineRunner {

    @Autowired
    private SocketIOServer socketIOServer;


    @Override
    public void run(String... args) throws Exception {
        this.socketIOServer.start();

    }
}

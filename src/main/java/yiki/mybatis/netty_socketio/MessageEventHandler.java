package yiki.mybatis.netty_socketio;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yiki.mybatis.react_app_bean.ChatSchema;
import yiki.mybatis.react_app_main.ChatService;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class MessageEventHandler {


    public static ConcurrentMap<String, SocketIOClient> socketIOClientMap =
            new ConcurrentHashMap<>();

    @Autowired
    private  ChatService chatService;



    //react-client
    @OnEvent(value = "sendMsg")
    public void react_onEvent(SocketIOClient client,
                              AckRequest request,
                              ChatSchema chat) {
        //回发消息
//        chatService.storeMsg(data);
//        client.sendEvent("receveMsg", chat);
        chatService.postMsg(chat);
        //广播消息
        sendBroadcast(chat);
    }



    /**
     * 客户端连接的时候触发
     *
     * @param client
     */
    @OnConnect
    public void onConnect(SocketIOClient client) {
//        String mac = client.getHandshakeData().getSingleUrlParam("mac");
        //存储SocketIOClient，用于发送消息
        //回发消息
        client.sendEvent("message", "onConnect back");
//        System.out.println("客户端:" + client.getSessionId() + "已连接,mac=" + mac);
        System.out.println("客户端:" + client.getSessionId() + "已连接");
        socketIOClientMap.put(client.getSessionId().toString(), client);

    }

    /**
     * 客户端关闭连接时触发
     *
     * @param client
     */
    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        System.out.println("客户端:" + client.getSessionId() + "断开连接");
    }

    /**
     * 客户端事件
     *
     * @param client  　客户端信息
     * @param request 请求信息
     * @param data    　客户端发送数据
     */
    @OnEvent(value = "messageevent")
    public void onEvent(SocketIOClient client, AckRequest request, Message data) {
        //回发消息
        client.sendEvent("messageevent", "我是服务器都安发送的信息");
        //广播消息
    }

    /**
     * 广播消息
     */
    public void sendBroadcast(ChatSchema chat) {
        for (SocketIOClient client : socketIOClientMap.values()) {
            if (client.isChannelOpen()) {
                client.sendEvent("receveMsg", chat);
            }
        }

    }



}

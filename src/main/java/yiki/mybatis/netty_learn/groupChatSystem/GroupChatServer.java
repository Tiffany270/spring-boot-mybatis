package yiki.mybatis.netty_learn.groupChatSystem;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/*
 * Group chat system Demo
 * 算了因为是springboot不能有多个main，client就不写了，telnet收不到回显= =。
 * */
public class GroupChatServer {

    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int PORT = 6667;

    //init
    public GroupChatServer() {
        try {

            selector = Selector.open();
            listenChannel = ServerSocketChannel.open();
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            //no-blocking module
            listenChannel.configureBlocking(false);
            //register to selector
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // listening, must as a loop
    public void listen() {
        try {
            while (true) {
//                int count = selector.select(2000);//2s
                int count = selector.select();//2s

                if (count > 0) {// have events to handle

                    //get selectionKey set ( channels)
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        //accept
                        if (key.isAcceptable()) {
                            SocketChannel sc = listenChannel.accept();
                            sc.configureBlocking(false);
                            sc.register(selector, SelectionKey.OP_READ);
                            System.out.println(sc.getRemoteAddress() + "is online");
                        }

                        // received and distribution the news
                        if (key.isReadable()) {
                            // do sth..
                            readData(key);


                        }
                        //remove current key to avoid repeat
                        iterator.remove();
                    }
                } else {
                    System.out.println("waiting....");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

        }

    }

    // Func for receiving and distribution of the news

    private void readData(SelectionKey key) {//via key to get certain channel
        SocketChannel channel = null;
        try {
            channel = (SocketChannel) key.channel();
            //get channel's data to buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int count = channel.read(buffer);// is a length

            //according value of count to do sth
            if (count > 0) {//output
                String msg = new String(buffer.array());
                System.out.println("from client: " + msg);
                // distributed data to other clients
                sendInfo(msg, channel);
            }

        } catch (IOException e) {
            try { // when sb is off-line
                System.out.println(channel.getRemoteAddress() + "is offline");
                key.cancel();
                channel.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

    }

    // distributed data to other clients (except itself)
    private void sendInfo(String msg, SocketChannel self) throws IOException {
        System.out.println("distributing...");

        for (SelectionKey key : selector.keys()) {
            Channel target = key.channel();
            if ((target instanceof SocketChannel) && target != self) {
                SocketChannel dest = (SocketChannel) target;
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                // put buffer's data write to channel
                dest.write(buffer);
            }
        }

    }

    public static void startServer() {
        GroupChatServer chatServer = new GroupChatServer();
        chatServer.listen();

    }

}

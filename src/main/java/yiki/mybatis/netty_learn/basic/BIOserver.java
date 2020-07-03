package yiki.mybatis.netty_learn.basic;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BIO模型编写的服务器，一个socket对一个线程
 * 端口为：6666
 *
 * 客户端cmd发送方式：
 * - telnet
 * - ctrl+]
 * - [send] + your word
 */

public class BIOserver {

    /*线程池机制
    - 创建一个线程池
    - 如有客户端连接就创建一个线程与之通讯
    */
    public static void startBIO() throws Exception {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        System.out.println("BIO Server Started");

        ServerSocket serverSocket = new ServerSocket(6666);
        while (true) {
            //  监听
            final Socket socket = serverSocket.accept();
            System.out.println("FInd an Client");

            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {//重写
                    // 和客户端
                    handler(socket);
                }
            });
        }
    }

    //与客户端通讯的方法
    public static void handler(Socket socket) {
        try {
            System.out.println("id: "+Thread.currentThread().getId());
            System.out.println("name: "+Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            //通过socket获得一个输入流
            InputStream inputStream = socket.getInputStream();
            //循环读取客户端发送的数据

            while (true) {
                // read会造成阻塞
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(new String(bytes,0,read));
                } else {
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //不管发生了什么都要执行关闭
            System.out.println("server is closed");
            try {
                socket.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
    }
}

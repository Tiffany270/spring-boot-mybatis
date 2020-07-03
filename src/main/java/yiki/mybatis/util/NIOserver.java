package yiki.mybatis.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/*
        Non blocking IO
        同步非阻塞, for BLOCK to handle data

                - tread             - tread
                     |                ...
                - selector
         (listening events from channel)

        - channel   - channel
            ||          ||
        - buffer    - buffer

* */
public class NIOserver {

    // what's buffer : there are various types of buffer
    public void basicBuffer() {
        // create an 5size buffer
        IntBuffer buffer = IntBuffer.allocate(5);
        //store data to buffer
        buffer.put(10);
        buffer.put(10);
        buffer.put(10);
        buffer.put(10);

        // get data from buffer
        // switch read or write
        //buffer's position would change
        buffer.flip();
        while (buffer.hasRemaining()) {
            // get->index changes
            System.out.println(buffer.get());
        }
    }

    //what's channel
    public void basicFileChannelWrite() throws Exception {
        String str = "hello";
        //create an output stream
        FileOutputStream outputStream = new FileOutputStream("d:\\file.01.text");
        // the real type of channel is "FileChannelImpl"
        FileChannel channel = outputStream.getChannel();
        //create an buffer zone ->buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(str.getBytes());
        //because position had changed,so flipped it
        byteBuffer.flip();
        //put data that from buffer write to fileChannel
        channel.write(byteBuffer);
        //Don't forget to close your stream
        outputStream.close();

    }

    public void basicFileChannelRead() throws Exception {

        // create an inputStream
        File file = new File("d:\\file.text");
        FileInputStream inputStream = new FileInputStream(file);
        FileChannel channel = inputStream.getChannel();
        //crete buffer zone
        ByteBuffer buffer = ByteBuffer.allocate((int) file.length());
        // read data that from channel into buffer
        channel.read(buffer);
        //turn byte to string
        System.out.println(new String(buffer.array()));
        inputStream.close();


    }


    //Scattering: use buffer array write in order
    //Gathering: read data from buffer, use buffer array read in order
    public static void scattering_gathering() throws Exception {

        ServerSocketChannel channel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(7000);

        // bind port to socket and open it
        channel.socket().bind(address);

        System.out.println("serve started");



        ByteBuffer[] byteBuffer = new ByteBuffer[2];
        byteBuffer[0] = ByteBuffer.allocate(5);
        byteBuffer[1] = ByteBuffer.allocate(3);

        //waiting for client to connect
        SocketChannel socketChannel = channel.accept();

        int msgLen = 8;// limit client data is 8 bytes
        //read in loop
        while (true) {
            int byteRead = 0;
            while (byteRead < 8) {
                System.out.println("loop started");

                long count = socketChannel.read(byteBuffer);
                byteRead += count;
                // use stream to print
                Arrays.asList(byteBuffer).stream().map
                        (item -> item.position() +
                                item.limit()).
                        forEach(System.out::println);

                //reverse
                Arrays.asList(byteBuffer).forEach(item -> item.flip());

                // return back to your client
                long byteWrite = 0;
                while (byteWrite < msgLen) {
                    long count2 = socketChannel.write(byteBuffer);
                    byteWrite += count2;
                }

                System.out.println("byteRead: " + byteRead);
                System.out.println("byteWrite: " + byteWrite);


                System.out.println("clear buffer");

                //clear buffer
                Arrays.asList(byteBuffer).forEach(item -> {
                    item.clear();
                });



            }
        }


    }


}

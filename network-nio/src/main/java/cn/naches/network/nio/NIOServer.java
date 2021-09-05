package cn.naches.network.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NIOServer {
    static List<SocketChannel> channelList = new ArrayList();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9001));

        serverSocketChannel.configureBlocking(false);
        System.out.println("Server started.");

        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();

            if(socketChannel != null){
                System.out.println("Connection Success.");
                socketChannel.configureBlocking(false);

                channelList.add(socketChannel);
            }

            Iterator<SocketChannel> iterator = channelList.iterator();

            while (iterator.hasNext()){
                SocketChannel channel = iterator.next();
                ByteBuffer byteBuffer = ByteBuffer.allocate(512);

                int len = channel.read(byteBuffer);

                if( len > 0){
                    System.out.println("Received msg: " + new String(byteBuffer.array()));
                }else if( len == -1){
                    iterator.remove();
                    System.out.println("Client disconnected.");
                }
            }
        }
    }
}

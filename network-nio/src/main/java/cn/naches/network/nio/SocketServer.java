package cn.naches.network.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            System.out.println("Wait for connection...");

            final Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            new Thread(new Runnable() {
                public void run() {
                    try {
                        handle(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    private static void handle(Socket clientSocket) throws IOException {
        byte[] bytes = new byte[1024];
        System.out.println("Ready to read:");
        int read = clientSocket.getInputStream().read(bytes);
        System.out.println("Read completed");
        if (read != -1){
            System.out.println("Received client msg: " + new String(bytes, 0, read));
        }
        clientSocket.getOutputStream().write("Hello Client".getBytes());
        clientSocket.getOutputStream().flush();
    }
}

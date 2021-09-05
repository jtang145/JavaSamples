package cn.naches.network.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

final class Handler implements Runnable {
    final SocketChannel socketChannel;
    final SelectionKey selectionKey;

    ByteBuffer input = ByteBuffer.allocate(1024);
    ByteBuffer output = ByteBuffer.allocate(1024);

    static final int READING = 0, SENDING = 1;

    int state = READING;

    Handler(Selector selector, SocketChannel socketChannel) throws IOException {
        this.socketChannel = socketChannel;
        this.socketChannel.configureBlocking(false);
        this.selectionKey = this.socketChannel.register(selector, 0);
        this.selectionKey.attach(this);
        this.selectionKey.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }

    public void run() {
        System.out.println("processing data by handler");
        try {
            if (state == READING)
                read();
//            else if (state == SENDING)
//                send();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void read() throws IOException {
        System.out.println("reading data by handler");
        socketChannel.read(input);
        if (inputIsComplete()) {
            process();
//            state = SENDING;
//            selectionKey.interestOps(SelectionKey.OP_WRITE);
            selectionKey.attach(new Sender());
            selectionKey.interestOps(SelectionKey.OP_WRITE);
            selectionKey.selector().wakeup();
        }
    }

    private void process() {
        System.out.println("Client: " + new String(input.array()));
        System.out.println("Do some biz logic here.");
    }

    private boolean inputIsComplete() {
        input.rewind();
        return !input.hasRemaining();
    }

    private void send() throws IOException {
        socketChannel.write(output);
        if (outputIsComplete()) {
            selectionKey.cancel();
        }
    }

    private boolean outputIsComplete() {
        output.rewind();
        return !output.hasRemaining();
    }

    class Sender implements Runnable {

        public void run() {
            try {
                System.out.println("processing write");
                socketChannel.write(output);
                if (outputIsComplete()) {
                    selectionKey.cancel();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

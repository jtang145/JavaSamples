package cn.naches.network.reactor;

import java.io.IOException;

public class ReactorServer {
    public static void main(String[] args){
        try {
            (new Reactor(9099)).run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

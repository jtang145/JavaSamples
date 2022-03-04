package cn.naches.rmi;

import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1099;
        try {
            Registry registry = LocateRegistry.getRegistry(host, port);

            String url = "rmi://localhost:1099/evil";
//            String url = "java:cn/naches/rmi/EvilObj";
            InitialContext initialContext = new InitialContext();
            Object obj = initialContext.lookup(url);

//            EvilObj a = null;

//            obj.hello();

            System.out.println("rmi client result:");
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

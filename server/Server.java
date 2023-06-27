package server;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            int port = 1099;
            
            dbProcess proc = new ProcessImpl();

            LocateRegistry.createRegistry(port);

            Naming.rebind("rmi://localhost:"+port+"/Process", proc);

            System.out.println("Server is running and waiting for client requests");
        } catch (Exception e) {
            System.out.println("Server Exception: "+ e.getMessage());
        }
    }
}
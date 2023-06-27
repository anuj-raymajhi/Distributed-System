package server;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface dbProcess extends Remote {
    // Defining behaviors/methods
    // writing methods

    public void addRecord(String name, String address, String roll, int grade) throws RemoteException;

    // reading methods
    
    public String getRecord(String roll) throws RemoteException;

}

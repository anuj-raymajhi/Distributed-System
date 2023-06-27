import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Process extends Remote {

    public void addRecord(String name, String address, String roll, int grade) throws RemoteException;

    public String getRecord(String roll) throws RemoteException;

}

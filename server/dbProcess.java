package server;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface dbProcess extends Remote {
    // Defining behaviors/methods
    // writing methods
    // public void addName(String name) throws RemoteException;
    // public void addAddress(String address) throws RemoteException;
    // public void addRollNo(String roll) throws RemoteException;
    // public void addGrade(int grade) throws RemoteException;

    public void addRecord(String name, String address, String roll, int grade) throws RemoteException;

    // reading methods
    // public String getName() throws RemoteException;
    // public String getAddress() throws RemoteException;
    // public String getRollNo() throws RemoteException;
    // public int getGrade() throws RemoteException;

    public String getRecord(String roll) throws RemoteException;

}

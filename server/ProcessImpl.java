package server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// import java.sql.Statement;


public class ProcessImpl extends UnicastRemoteObject implements dbProcess {

    protected ProcessImpl() throws RemoteException{
        super();
        establishConnection();
    }
    private static final long serialVersionUID = 1L;
    private Connection connection;

    private void establishConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            
            String dbFile = "server\\student.db";

            connection = DriverManager.getConnection("jdbc:sqlite:"+dbFile);

            System.out.println("Connection Established to the Database");

        }
        catch(ClassNotFoundException | SQLException e) {
            System.out.println("Failed to Establish Database Connection: " + e.getMessage() );
        }
    }

    // @Override
    public void addRecord(String name, String address, String roll, int grade) throws RemoteException {
        try {

            PreparedStatement prepStatement = null;
            // Statement statement = connection.createStatement();
            String query = "INSERT INTO student (Name, RollNo, Address, Grade) VALUES (?,?,?,?)";
            prepStatement = connection.prepareStatement(query);

            prepStatement.setString(1,name);
            prepStatement.setString(2, roll);
            prepStatement.setString(3, address);
            prepStatement.setInt(4, grade);

            prepStatement.executeUpdate();

            System.out.println("Record Successfully Added.");

        } catch (SQLException e) {

            System.out.println("Failed to add into database: "+e.getMessage());

        }
    }

    // @Override
    public String getRecord(String roll) throws RemoteException {
        String results = "";
        
        try {
            
            PreparedStatement prepStatement = null;
            // Statement statement = connection.createStatement();
            String query = "SELECT * FROM student WHERE RollNo = \"?\"";
            prepStatement = connection.prepareStatement(query);
            prepStatement.setString(1, roll);
            ResultSet resultSet = prepStatement.executeQuery();
            while(resultSet.next()){
                results += resultSet.getString("column_name") + "\n";
            }
        } catch (SQLException e) {
            System.out.println("Failed to read data from the database: "+e.getMessage());
        }
        return results;
    }
}

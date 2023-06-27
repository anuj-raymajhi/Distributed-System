import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {

            int port = 1099;
            
            Process proc = (Process) Naming.lookup("rmi://localhost:"+port+"/Process");

            Scanner sc = new Scanner(System.in);

            boolean breakConnection = false;
            String name = "";
            String roll = "";
            String address = "";
            int grade = 0; 
            int choice;
            String result;

            System.out.println("WELCOME TO Student Information System");
            System.out.println("1. Add Record");
            System.out.println("2. Get Record");
            System.out.println("3. Exit");
            while(!breakConnection) {
                System.out.print("Enter Choice(1/2/3): ");
                choice = sc.nextInt();
                switch(choice){
                    case 1:
                    try {

                        System.out.print("Enter name: ");
                        name=sc.nextLine();
                        System.out.print("Enter Roll Number: ");
                        roll=sc.nextLine();
                        System.out.print("Enter Address: ");
                        address = sc.nextLine();
                        System.out.print("Enter Grade: ");
                        grade = sc.nextInt();

                        proc.addRecord(name, address, roll, grade);
                        System.out.println("Successfully added to the database.");

                    } catch (Exception e) {
                        System.out.println("Error while adding data: "+e.getMessage());
                    }
                    break;

                    case 2:
                    System.out.print("Enter Roll no. : ");
                    roll = sc.next();
                    result = proc.getRecord(roll);
                    System.out.println(result);
                    break;

                    case 3:
                    breakConnection = true;
                    break;
                    
                    default:
                    System.out.println("Enter a valid choice.");
                    break;
                }
            }

            sc.close();
            System.out.println("Client Program closed.");

        } catch (Exception e) {
            System.out.println("Client Exception: "+e.getMessage());
        }
    }
}

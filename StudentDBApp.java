import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import student.StudentFunctions;
import helper.UtilityFunctions;

public class StudentDBApp {

    private static final String url = "jdbc:mysql://localhost:3306/StudentDB";
    private static final String username = "root";
    private static final String password = "Dev@ece1626";
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers Loaded!!");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected Succesfully!!");
            boolean loopOn = true;
            while(loopOn){
                UtilityFunctions.clearScreen();
                UtilityFunctions.greetMessage();
                UtilityFunctions.showMenu();
                int choice = UtilityFunctions.getChoice(scanner);
                if(choice == 1) StudentFunctions.addStudent(connection, scanner);
                else if(choice == 2) StudentFunctions.removeStudent(connection, scanner);
                else if(choice == 3) StudentFunctions.showDatabase(connection);
                loopOn = UtilityFunctions.exit(scanner);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
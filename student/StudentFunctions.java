package student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentFunctions {
    
    public static int getNoOfRows(Connection connection) {
        String queryOne = "SELECT COUNT(*) FROM students;";
        int noOfRows = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryOne);
            while (resultSet.next()) {
                noOfRows = resultSet.getInt(1);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return noOfRows;
    }

    public static void addStudent(Connection connection, Scanner scanner) {

        System.out.println("Enter First Name:");
        String firstName = scanner.next().trim();
        System.out.println("Enter Last Name:");
        String lastName = scanner.next().trim();
        System.out.println("Enter Contact number:");
        String contactNo = scanner.next().trim();
        System.out.println("Enter Email:");
        String email = scanner.next().trim();


        int noOfRows = getNoOfRows(connection);

        if(noOfRows != 0){
            String query = "INSERT INTO students(first_name, last_name, contact_no, email) VALUES('" + firstName + "','" + lastName + "','" + contactNo + "','" + email + "');";
            try {
                Statement statement2 = connection.createStatement();
                int resultSet2 = statement2.executeUpdate(query);
                if(resultSet2 > 0) System.out.println("Student added!!");
                else System.out.println("Failed to add student!!. Try again");
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            String query = "INSERT INTO students(id,first_name, last_name, contact_no, email) VALUES(1001,'"+ firstName + "','" + lastName + "','" + contactNo + "','" + email + "');";
            try {
                Statement statement2 = connection.createStatement();
                int resultSet2 = statement2.executeUpdate(query);
                if(resultSet2 > 0) System.out.println("Student added!!");
                else System.out.println("Failed to add student!!. Try again");
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

    public static void removeStudent(Connection connection, Scanner scanner){
        System.out.println("Enter the Student ID: ");
        String id = scanner.next().trim();
        String query = "DELETE FROM students WHERE id = "+ id;
        try {
            Statement statement = connection.createStatement();
            int resultSet = statement.executeUpdate(query);
            if(resultSet > 0) System.out.println("Deleted Succesfully");
            else System.out.println("Failed to Delete");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showDatabase(Connection connection){
        if(getNoOfRows(connection) == 0) System.out.println("Database is Empty!!");
        else{
            String query = "SELECT * FROM students;";
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                System.out.println("+--------------------------------------------------------------------------------------------------+");
                System.out.printf("| %s | %15s | %15s | %10s | %40s |\n","id  ","FIRSTNAME","LASTNAME","CONTACT", "EMAIL");
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    String contactNo = resultSet.getString(4);
                    String email = resultSet.getString(5);
                    System.out.println("+--------------------------------------------------------------------------------------------------+");
                    System.out.printf("| %d | %15s | %15s | %10s | %40s |\n",id,firstName,lastName,contactNo, email);
                    
                }
                System.out.println("+--------------------------------------------------------------------------------------------------+");
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

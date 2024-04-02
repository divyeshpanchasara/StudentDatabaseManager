package helper;

import java.util.Scanner;

public class UtilityFunctions {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public static int getChoice(Scanner scanner){
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        while (choice > 3 || choice < 0) {
            System.out.println("INVALID INPUT!!");
            System.out.print("Enter choice again: ");
            choice = scanner.nextInt();
        }
        return choice;
    }

    public static void showMenu() {
        System.out.println("1. Add a Student");
        System.out.println("2. Delete a Student");
        System.out.println("3. View Student Database;");
        System.out.println("0. EXIT");
    }

    public static void greetMessage() {
        System.out.println("\t\t\tWELCOME TO THE STUDENT DATABASE");
    }

    public static boolean exit(Scanner scanner) {
        System.out.println("Would you like to exit?? Y/N");
        char ch = scanner.next().charAt(0);
        if(ch == 'Y') return false;
        return true;
    }
}

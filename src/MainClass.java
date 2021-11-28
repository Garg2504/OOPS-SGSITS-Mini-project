import java.time.LocalDate;
import java.util.Scanner;

/**
 * Created by Adrian Adewunmi on 12/11/21.
 * Version: 1.0
 * Main class: Implements a console-based menu-driven application
 *
 */
public class MainClass {
    public static void main(String[] args) {
        int selectMainMenu;
        int selectSubMenu;
        College newCollege = new College("New College");
        System.out.println("===================================\n" + newCollege.getCollegeName()
                + " Financial System"
                + " (NCFS)" + "\n===================================");
        LocalDate date = LocalDate.now();
        System.out.println("Date: " + date + "\n");
        do{
            System.out.println("\n=== NCFS Main Menu ===");
            System.out.println("1. Teachers Finance\n" +
                    "2. Students Finance\n" +
                    "3. College Finance\n" +
                    "4. Exit");
            System.out.print("\nSelect an option: ");
            Scanner scannerMainMenu = new Scanner(System.in);
            selectMainMenu = scannerMainMenu.nextInt();
            switch (selectMainMenu){
                case 1:
                    System.out.println("\n=== Teachers Finance ===");
                    do{
                        System.out.println("1. Add Teacher\n" +
                                "2. Find Teacher\n" +
                                "3. Increase Salary\n" +
                                "4. Delete Teacher\n" +
                                "5. Print All Teachers\n" +
                                "6. Exit");
                        System.out.print("\nSelect an option: ");
                        Scanner scannerSubMenu = new Scanner(System.in);
                        selectSubMenu = scannerSubMenu.nextInt();
                        switch (selectSubMenu){
                            case 1:
                                addTeachers(newCollege);
                                break;
                            case 2:
                                System.out.println("\n=== Find Teacher ===\n");
                                break;
                            case 3:
                                System.out.println("\n=== Increase Salary ===\n");
                                break;
                            case 4:
                                System.out.println("\n=== Delete Teacher ===\n");
                                break;
                            case 5:
                                printAllTeachers(newCollege);
                                break;
                            case 6:
                                System.out.println("\n=== Exit ===");
                                break;
                        }
                    }while(selectSubMenu != 6);
                    break;
                case 2:
                    System.out.println("\n=== Students Finance ===");
                    break;
                case 3:
                    System.out.println("\n=== College Finance ===");
                    break;
                case 4:
                    System.out.println("\nThank you for using NCFS");
                    break;
            }
        }while(selectMainMenu != 4);
    }

    public static void addTeachers(College newCollege){
        char y = 'y';
        System.out.println("=== Add Teacher ===");
        do{
            System.out.print("\nEnter teacher id: ");
            Scanner scanner = new Scanner(System.in);
            String teacherID = scanner.nextLine();
            System.out.print("Enter the name of the teacher: ");
            scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            System.out.print("Enter the salary of the teacher: ");
            double salary = scanner.nextDouble();
            Teacher newTeacher = new Teacher(teacherID, name, salary);
            newCollege.addTeacher(newTeacher);
            System.out.print("\nAdd another teacher? (y/n): \n");
            scanner = new Scanner(System.in);
            y = scanner.next().charAt(0);
        } while(y == 'y');
    }

    public static void printAllTeachers(College newCollege){
        System.out.println("\n=== Teachers ===");
        newCollege.printListOfTeachers();
        System.out.println("\n");
    }
}

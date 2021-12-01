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
        int selectSubMenuTeacher;
        int selectSubMenuStudent;
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
                        Scanner scannerSubMenuTeacher = new Scanner(System.in);
                        selectSubMenuTeacher = scannerSubMenuTeacher.nextInt();
                        switch (selectSubMenuTeacher){
                            case 1:
                                addTeachers(newCollege);
                                break;
                            case 2:
                                findTeacher(newCollege);
                                break;
                            case 3:
                                increaseSalary(newCollege);
                                break;
                            case 4:
                                removeTeacher(newCollege);
                                break;
                            case 5:
                                printAllTeachers(newCollege);
                                break;
                            case 6:
                                System.out.println("\n=== Exiting Teacher Menu ===");
                                break;
                        }
                    }while(selectSubMenuTeacher != 6);
                    break;
                case 2:
                    System.out.println("\n=== Students Finance ===");
                    do{
                        System.out.println("1. Add Student\n" +
                                "2. Find Student\n" +
                                "3. Pay Tuition Fees\n" +
                                "4. Outstanding Fees\n" +
                                "5. Delete Student\n" +
                                "6. Print All Students\n" +
                                "7. Exit");
                        System.out.print("\nSelect an option: ");
                        Scanner scannerSubMenuStudent = new Scanner(System.in);
                        selectSubMenuStudent = scannerSubMenuStudent.nextInt();
                        switch (selectSubMenuStudent){
                            case 1:
                                System.out.println("\n=== Adding Student ===");
                                break;
                            case 2:
                                System.out.println("\n=== Finding Student ===");
                                break;
                            case 3:
                                System.out.println("\n=== Paying Tuition Fees ===");
                                break;
                            case 4:
                                System.out.println("\n=== Outstanding Fees ===");
                                break;
                            case 5:
                                System.out.println("\n=== Deleting Student ===");
                                break;
                            case 6:
                                System.out.println("\n=== Printing All Students ===");
                                break;
                            case 7:
                                System.out.println("\n=== Exiting Teacher Menu ===");
                                break;
                        }
                    }while(selectSubMenuStudent != 7);
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

    private static void increaseSalary(College newCollege) {
        System.out.println("=== Increase Teachers Salary ===");
        Scanner scanner;
        String teacherID;
        char y;
        do{
            System.out.print("\nEnter teacher id: ");
            scanner = new Scanner(System.in);
            teacherID = scanner.nextLine();
            if (newCollege.findTeacher(teacherID)) {
                System.out.print("Enter the amount to increase salary: ");
                scanner = new Scanner(System.in);
                double increase = scanner.nextDouble();
                newCollege.increaseTeacherSalary(teacherID, increase);
            }else {
                System.out.println("Teacher not found");
            }
            System.out.print("\nFind another teacher? (y/n): \n");
            scanner = new Scanner(System.in);
            y = scanner.next().charAt(0);
        } while(y == 'y');
    }

    private static void removeTeacher(College newCollege) {
        System.out.println("\n=== Delete Teacher ===");
        char y;
        do{
            System.out.print("\nEnter teacher id: ");
            Scanner scanner = new Scanner(System.in);
            String teacherID = scanner.nextLine();
            if (newCollege.findTeacher(teacherID)) {
                newCollege.removeTeacher(teacherID);
                System.out.println("\nTeacher deleted successfully!");
            }else {
                System.out.println("Teacher not found");
            }
            System.out.print("\nRemove another teacher? (y/n): \n");
            scanner = new Scanner(System.in);
            y = scanner.next().charAt(0);
        } while(y == 'y');
    }

    private static void findTeacher(College newCollege){
        System.out.println("\n=== Find Teacher ===");
        char y;
        do{
            System.out.print("\nEnter teacher id: ");
            Scanner scanner = new Scanner(System.in);
            String teacherID = scanner.nextLine();
            if (newCollege.findTeacher(teacherID)) {
                System.out.println("\nTeacher found");
            }else {
                System.out.println("Teacher not found");
            }
            System.out.print("\nFind another teacher? (y/n): \n");
            scanner = new Scanner(System.in);
            y = scanner.next().charAt(0);
        } while(y == 'y');
    }

    public static void addTeachers(College newCollege){
        char y;
        System.out.println("=== Add Teacher ===");
        do{
            enterTeacherDetails(newCollege);
            System.out.print("\nAdd another teacher? (y/n): \n");
            Scanner scanner = new Scanner(System.in);
            y = scanner.next().charAt(0);
        } while(y == 'y');
    }

    public static void enterTeacherDetails(College newCollege){
        System.out.print("\nEnter teacher id: ");
        Scanner scanner = new Scanner(System.in);
        String teacherID = scanner.nextLine();
        System.out.print("Enter the name of the teacher: ");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.print("Enter the salary of the teacher: ");
        double salary = scanner.nextDouble();
        if ((salary > 0) && (salary < 1000000)) {
            Teacher newTeacher = new Teacher(teacherID, name, salary);
            newCollege.addTeacher(newTeacher);
        }else {
            System.out.println("Salary must be between £1.00 and £1000000.00\n"
                    + "Please enter a valid salary");
        }
    }

    public static void printAllTeachers(College newCollege){
        System.out.println("\n=== Teachers List ===");
        newCollege.printListOfTeachers();
        System.out.println("\n");
    }
}

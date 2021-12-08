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
            System.out.println("\nSelect an option: ");
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
                        System.out.println("\nSelect an option: ");
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
                                System.out.println("\n=== Exiting Teachers Menu ===");
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
                        System.out.println("\nSelect an option: ");
                        Scanner scannerSubMenuStudent = new Scanner(System.in);
                        selectSubMenuStudent = scannerSubMenuStudent.nextInt();
                        switch (selectSubMenuStudent){
                            case 1:
                                addStudents(newCollege);
                                break;
                            case 2:
                                findStudent(newCollege);
                                break;
                            case 3:
                                payTuitionFees(newCollege);
                                break;
                            case 4:
                                removeStudent(newCollege);
                                break;
                            case 5:
                                printAllStudents(newCollege);
                                break;
                            case 6:
                                System.out.println("\n=== Exiting Students Menu ===");
                                break;
                        }
                    }while(selectSubMenuStudent != 6);
                    break;
                case 3:
                    System.out.println("\n=== College Finance ===");
                    break;
                case 4:
                    System.out.println("\n=== Exiting NCFS Main Menu ===\n" +
                            "Thank you and Good Bye!");
                    break;
            }
        }while(selectMainMenu != 4);
    }

    private static void payTuitionFees(College newCollege) {
        System.out.println("\n=== Pay Tuition Fees ===");
        char y;
        do{
            System.out.println("Enter student id: ");
            Scanner scanner = new Scanner(System.in);
            String studentID = scanner.nextLine();
            System.out.println("Enter student course code: ");
            String courseCode = scanner.nextLine();
            System.out.println("Enter Tuition Fee Payment: ");
            double tuitionFees = scanner.nextDouble();
            if(tuitionFees > 0){
                newCollege.payStudentTuitionFees(studentID, courseCode, tuitionFees);
            }else{
                System.out.println("\nInvalid tuition fee payment!\n" +
                        "Tuition fee payment must be greater than £1.00.");
            }
            System.out.println("\nDo you want to pay more tuition fees? (y/n)");
        y = scanner.next().charAt(0);
        }while (y == 'y');
    }

    private static void removeStudent(College newCollege) {
        System.out.println("\n=== Removing Student ===");
        char y;
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter student id: ");
            String studentID = scanner.nextLine();
            System.out.println("Enter student course code: ");
            String courseCode = scanner.nextLine();
            if(newCollege.findStudent(studentID, courseCode)){
                newCollege.removeStudent(studentID);
                System.out.println("\nStudent removed successfully\n");
            }else{
                System.out.println("\nStudent not found\n");
            }
            System.out.println("Do you want to try again? (y/n)");
            y = scanner.next().charAt(0);
            }while (y == 'y');
    }

    private static void findStudent(College newCollege) {
        System.out.println("\n=== Find Student ===");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student id: ");
        String studentID = scanner.nextLine();
        System.out.println("Enter student course code: ");
        String courseCode = scanner.nextLine();
        if(newCollege.findStudent(studentID, courseCode)){
            System.out.println("\n=== Student Found ===\n");
        }else{
            System.out.println("\n=== Student Not Found ===\n");
        }
    }

    private static void printAllStudents(College newCollege) {
        System.out.println("\n=== Students List ===");
        newCollege.printListOfStudents();
        System.out.println("\n");
    }

    private static void addStudents(College newCollege) {
        System.out.println("\n=== Adding Student ===");
        char y;
        do{
            Scanner scanner = new Scanner(System.in);
            enterStudentDetails(newCollege);
            System.out.println("\nAdd another student? (y/n): ");
            y = scanner.next().charAt(0);
        }while(y == 'y');
    }

    public static void enterStudentDetails(College newCollege){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student id: ");
        String studentId = scanner.nextLine();
        System.out.println("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.println("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.println("Enter course code: ");
        String courseCode = scanner.nextLine();
        System.out.println("Enter course fee: ");
        double courseFee = scanner.nextDouble();
        if ((!newCollege.findStudent(studentId, courseCode)) && (courseFee > 0 && courseFee < 100000)){
                Student newStudent = new Student(studentId, studentName, courseName, courseCode, courseFee);
                newCollege.addStudent(newStudent);
        }else {
            System.out.println("*** INVALID INPUT ***" );
            System.out.println("Student id already exists or Course code is invalid or Course Fee is less than £1.");
            System.out.println("(1) Duplicate student id is not allowed,\n" +
                    "(2) Course code must be unique,\n" +
                    "(3) Student course fee must be between £1.00 and £100000.00\n");
            System.out.println("Student not added!");
        }

    }

    private static void increaseSalary(College newCollege) {
        System.out.println("=== Increase Teachers Salary ===");
        Scanner scanner;
        String teacherID;
        char y;
        do{
            System.out.println("\nEnter teacher id: ");
            scanner = new Scanner(System.in);
            teacherID = scanner.nextLine();
            if (newCollege.findTeacher(teacherID)) {
                System.out.println("Enter the amount to increase salary: ");
                scanner = new Scanner(System.in);
                double increase = scanner.nextDouble();
                newCollege.increaseTeacherSalary(teacherID, increase);
                System.out.println("\n=== Salary Increase Successful ===\n");
            }else {
                System.out.println("\n==Teacher not found==\n");
            }
            System.out.println("\nFind another teacher? (y/n): \n");
            scanner = new Scanner(System.in);
            y = scanner.next().charAt(0);
        } while(y == 'y');
    }

    private static void removeTeacher(College newCollege) {
        System.out.println("\n=== Delete Teacher ===");
        char y;
        do{
            System.out.println("\nEnter teacher id: ");
            Scanner scanner = new Scanner(System.in);
            String teacherID = scanner.nextLine();
            if (newCollege.findTeacher(teacherID)) {
                newCollege.removeTeacher(teacherID);
                System.out.println("\nTeacher deleted successfully!\n");
            }else {
                System.out.println("\nTeacher not found\n");
            }
            System.out.println("\nRemove another teacher? (y/n): \n");
            scanner = new Scanner(System.in);
            y = scanner.next().charAt(0);
        } while(y == 'y');
    }

    private static void findTeacher(College newCollege){
        System.out.println("\n=== Find Teacher ===");
        char y;
        do{
            System.out.println("\nEnter teacher id: ");
            Scanner scanner = new Scanner(System.in);
            String teacherID = scanner.nextLine();
            if (newCollege.findTeacher(teacherID)) {
                System.out.println("\nTeacher found\n");
            }else {
                System.out.println("\nTeacher not found\n");
            }
            System.out.println("\nFind another teacher? (y/n): \n");
            scanner = new Scanner(System.in);
            y = scanner.next().charAt(0);
        } while(y == 'y');
    }

    public static void addTeachers(College newCollege){
        char y;
        System.out.println("=== Add Teacher ===");
        do{
            enterTeacherDetails(newCollege);
            System.out.println("\nAdd another teacher? (y/n): ");
            Scanner scanner = new Scanner(System.in);
            y = scanner.next().charAt(0);
        } while(y == 'y');
    }

    public static void enterTeacherDetails(College newCollege){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter teacher id: ");
        String teacherID = scanner.nextLine();
        System.out.println("Enter the name of the teacher: ");
        String name = scanner.nextLine();
        System.out.println("Enter the salary of the teacher: ");
        double salary = scanner.nextDouble();
        if ((!newCollege.findTeacher(teacherID)) && ((salary > 0) && (salary < 1000000))) {
            Teacher newTeacher = new Teacher(teacherID, name, salary);
            newCollege.addTeacher(newTeacher);
        }else {
            System.out.println("*** INVALID INPUT *** \n" );
            System.out.println("Teacher id already exists or Salary is invalid.");
            System.out.println("(1) Duplicate teacher id not allowed,\n" +
                    "(2) Salary must be between £1.00 and £1000000.00\n");
            System.out.println("Teacher not added");
        }
    }

    public static void printAllTeachers(College newCollege){
        System.out.println("\n=== Teachers List ===");
        newCollege.printListOfTeachers();
        System.out.println("\n");
    }
}

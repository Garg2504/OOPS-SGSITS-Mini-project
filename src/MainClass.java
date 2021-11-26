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
        College newCollege = new College("New College");
        System.out.println("===================================\n" + newCollege.getCollegeName() + " Financial System"
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
                    break;
                case 2:
                    System.out.println("\n=== Students Finance ===");
                    break;
                case 3:
                    System.out.println("\n=== College Finance ===");
                    break;
                case 4:
                    System.out.println("\nThank you for using NCFS");
            }
        }while(selectMainMenu != 4);
    }
}

package RPG;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UI ui = new UI(sc);
        String choice = "";
        ui.welcomeScreen();
        while (!choice.equals("6")) {
            System.out.println();
            System.out.println("==============================");
            System.out.println("Select action: ");
            System.out.println("1 - addPassword");
            System.out.println("2 - printAllPasswords");
            System.out.println("3 - findPassword");
            System.out.println("4 - deletePassword");
            System.out.println("5 - deleteAllPasswords");
            System.out.println("6 - end");
            System.out.println("==============================");
            choice = sc.nextLine().trim();
            System.out.println();

            switch (choice) {
                case "1":
                    ui.addPassword();
                    break;
                case "2":
                    ui.getAllPasswords();
                    break;
                case "3":
                    ui.findPasswords();
                    break;
                case "4":
                    ui.deletePassword();
                    break;
                case "5":
                    ui.deleteAllPasswords();
                    break;
                case "6":
                    //end
                    break;
                default:
                    System.out.println("Invalid selection, please re-enter.");
                    break;
            }
        }
        System.out.println("Thank you for using random password generator :)");
    }
}
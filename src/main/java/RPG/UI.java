package RPG;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    private Generator generator;
    private Scanner sc = new Scanner(System.in);
    private int passwordLength;

    public UI() {
        generator = new Generator();
    }

    public void welcomeScreen(){
        System.out.println("====================");
        System.out.println("Welcome to random password generator!");
        System.out.println("You can create a new random password");
    }

    private int parseInt() {
        System.out.println("Enter integer: (1 - 50)");
        while (true) {
            try {
                int input = Integer.parseInt(sc.nextLine().trim());
                if(input >= 1 && input <= 50){
                    return passwordLength = input;
                } else {
                    System.out.println("Incorrect number, please re-enter.");
                }
            } catch (Exception ex) {
                System.out.println("Incorrect entry, please re-enter.");
            }
        }
    }

    public void addPassword() {
        System.out.println();
        System.out.println("==============================");
        System.out.println("Create a new random password.");
        System.out.println("Choose a password length: ");
        parseInt();
        System.out.println();
        System.out.println("A new password was created.");
        generator.addPassword(passwordLength);
        passwordStrength(passwordLength);
        System.out.println("==============================");
        System.out.println();
    }

    public void passwordStrength(int passwordLength){
        if(passwordLength >= 1 && passwordLength <= 4){
            System.out.println("Password strength: Very Weak");
        } else if(passwordLength >= 5 && passwordLength <= 7){
            System.out.println("Password strength: Weak");
        } else if(passwordLength >= 8 && passwordLength <= 9){
            System.out.println("Password strength: Good");
        } else if(passwordLength >= 10 && passwordLength <= 11){
            System.out.println("Password strength: Strong");
        } else {
            System.out.println("Password strength: Very Strong Nice...");
        }
    }


    public void printAllPasswords() {
        ArrayList<Password> passwords = generator.findAllPasswords();
        System.out.println("All passwords are: \n");
        for (Password password : passwords) {
            System.out.println(password);
        }
    }

    public void findPasswords() {
        System.out.println("I can find all passwords of the same length");
        parseInt();
        ArrayList<Password> passwords = generator.findPassword(passwordLength);
        if (passwords.size() < 1) {
            System.out.println("No passwords found");
        } else {
            System.out.println("Found these passwords with length: " + passwordLength);
            for (Password password : passwords) {
                System.out.println(password);
            }
        }
    }

    public void deleteAllPasswords() {
        System.out.println("Do you want to delete all passwords? [Yes/No]");
        String choice = "";
        int delete = 0;
        while (delete == 0) {
            choice = sc.nextLine().toLowerCase().trim();
            if (choice.equals("yes") || choice.equals("y")) {
                generator.deleteALLPasswords(true);
                System.out.println("All passwords were deleted!");
                delete++;
            } else if (choice.equals("no") || choice.equals("n")) {
                System.out.println("Okey passwords won't be deleted ");
                delete++;
            } else {
                System.out.println("Please try it again.");
            }
        }
    }


    public void deletePassword() {
        System.out.println("Enter the length of the password. Passwords with this length will be deleted");
        parseInt();
        System.out.println("Do you want to delete password with this length? " + passwordLength + " [Yes/No]");
        String choice = "";
        int delete = 0;
        while (delete == 0) {
            choice = sc.nextLine().toLowerCase().trim();
            if (choice.equals("yes") || choice.equals("y")) {
                generator.deletePassword(passwordLength);
                System.out.println("All passwords with length: " + passwordLength + " will be deleted!");
                delete++;
            } else if (choice.equals("no") || choice.equals("n")) {
                System.out.println("Okey passwords won't be deleted ");
                delete++;
            } else {
                System.out.println("Please try it again.");
            }
        }
    }
}


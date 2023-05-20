package RPG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class UI {

    private Generator generator;
    private int passwordLength;
    private String charactersUsed;
    private Scanner sc;

    public UI(Scanner sc) {
        generator = new Generator();
        this.sc = sc;
    }

    public void welcomeScreen() {
        System.out.println("==============================");
        System.out.println("Welcome to random password generator!");
        System.out.println("You can create a new random password");
    }

    private int setPasswordLength() {
        System.out.println("Enter integer: (1 - 50)");
        while (true) {
            try {
                int input = Integer.parseInt(sc.nextLine().trim());
                if (input >= 1 && input <= 50) {
                    return passwordLength = input;
                } else {
                    System.out.println("Incorrect number, please re-enter.");
                }
            } catch (Exception ex) {
                System.out.println("Incorrect entry, please re-enter.");
            }
        }
    }

    private String setCharactersUsed() {
        System.out.println("Which characters you want to use?:  1 = ABC | 2 = abc | 3 = 123 | 4 = #$& | 5 = all");
        System.out.println("Enter integer: (1 - 5) Like 123 or 23 or 2 or 324... then hit enter");
        while (true) {
            String input = sc.nextLine().trim();
            if (input.matches("[1-5]+")) {
                return charactersUsed = input;
            } else {
                System.out.println("Incorrect entry, please re-enter.");
            }
        }
    }

    private void setUserWord() {
        System.out.println("Do you want to add your word? [Yes/No]: ");
        String choice = "";
        String userWord = "";
        int add = 0;
        int addd = 0;
        while (add == 0) {
            choice = sc.nextLine().toLowerCase().trim();
            if (choice.equals("yes") || choice.equals("y")) {
                System.out.println("Enter your word: ");
                userWord = sc.nextLine().trim();
                generator.setCustomWord(userWord);
                add++;
                while (addd == 0) {
                    if (choice.equals("yes") || choice.equals("y")) {
                        System.out.println("Do you want to put your word at the beginning or at the end" +
                                " [beginning = b | end = e]");
                        String beginnigOrEndChoice = sc.nextLine().toLowerCase().trim();
                        if (beginnigOrEndChoice.equals("b") || beginnigOrEndChoice.equals("beginning")) {
                            generator.setWordEndOrFront(beginnigOrEndChoice);
                            addd++;
                        } else if (beginnigOrEndChoice.equals("e") || beginnigOrEndChoice.equals("end")) {
                            generator.setWordEndOrFront(beginnigOrEndChoice);
                            addd++;
                        } else {
                            System.out.println("Incorrect entry, please re-enter.");
                        }
                    }
                }
            } else if (choice.equals("no") || choice.equals("n")) {
                System.out.println("Okey no word");
                generator.setCustomWord("");
                generator.setWordEndOrFront("");
                add++;
            } else {
                System.out.println("Incorrect entry, please re-enter.");
            }
        }
    }

    public void addPassword() {
        System.out.println("Create a new random password.");
        System.out.println("Choose a password length: ");
        setPasswordLength();
        System.out.println("Choose a characters you want to use: ");
        setCharactersUsed();
        setUserWord();
        System.out.println("A new password was created. Your new password is below: ");
        generator.addPassword(passwordLength, charactersUsed);
        getPasswordStrength();
    }

    private void getPasswordStrength() {
        int bothWords = generator.getNewPassword().length();
        if (bothWords >= 1 && bothWords <= 4) {
            System.out.println("Password strength: Very Weak");
        } else if (bothWords >= 5 && bothWords <= 7) {
            System.out.println("Password strength: Weak");
        } else if (bothWords >= 8 && bothWords <= 9) {
            System.out.println("Password strength: Good");
        } else if (bothWords >= 10 && bothWords <= 11) {
            System.out.println("Password strength: Strong");
        } else {
            System.out.println("Password strength: Very Strong Nice...");
        }
    }

    public void getAllPasswords() {
        ArrayList<Password> passwords = generator.findAllPasswords();
        passwords.sort((s1, s2) -> s1.getPasswordLength() - s2.getPasswordLength());
        if (passwords.size() < 1) {
            System.out.println("No passwords found");
        } else {
            System.out.println("All passwords sorted by length are: ");
            for (Password password : passwords) {
                System.out.println(password + "   |with length: " + password.getPasswordLength());
            }
        }
    }

    public void findPasswords() {
        System.out.println("I can find all passwords of the same length");
        setPasswordLength();
        ArrayList<Password> passwords = generator.findPassword(passwordLength);
        if (passwords.size() < 1) {
            System.out.println("No passwords found with length: " + passwordLength);
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
        setPasswordLength();
        System.out.println("Do you want to delete password with this length? " + passwordLength + " [Yes/No]");
        String choice = "";
        int delete = 0;
        while (delete == 0) {
            choice = sc.nextLine().toLowerCase().trim();
            if (choice.equals("yes") || choice.equals("y")) {
                generator.deletePassword(passwordLength);
                System.out.println("All passwords with length: " + passwordLength + " were deleted!");
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



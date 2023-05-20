package RPG;

import java.util.ArrayList;
import java.util.Random;

public class Generator {

    private ArrayList<Password> passwords;
    private final char[] LARGE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final char[] SMALL_CHARACTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private final char[] CHARCTERS = "?.-!/@€&#%*-+<>".toCharArray();
    private final char[] NUMBERS = "1234567890".toCharArray();
    private Random randomChar;
    private String newPassword = "";
    private String customWord;
    private String wordEndOrFront;

    public Generator() {
        randomChar = new Random();
        passwords = new ArrayList<>();
    }

    public void addPassword(int passwordLength, String characterUsed) {
        wordEndOrFront = this.wordEndOrFront;
        customWord = this.customWord;
        newPassword = "";
        if (wordEndOrFront.equals("b") || wordEndOrFront.equals("beginning")) {
            newPassword = customWord + generatePassword(passwordLength, characterUsed);
            passwords.add(new Password(newPassword, passwordLength + customWord.length()));
            System.out.println(newPassword);
        } else {
            newPassword = generatePassword(passwordLength, characterUsed) + customWord;
            passwords.add(new Password(newPassword, passwordLength + customWord.length()));
            System.out.println(newPassword);
        }
    }

    public String generatePassword(int passwordLength, String characterUsed) {
        StringBuilder passwordBuilder = new StringBuilder();
        StringBuilder password = new StringBuilder();
        if (characterUsed.contains("1")) {
            passwordBuilder.append(LARGE_CHARACTERS);
        }
        if (characterUsed.contains("2")) {
            passwordBuilder.append(SMALL_CHARACTERS);
        }
        if (characterUsed.contains("3")) {
            passwordBuilder.append(NUMBERS);
        }
        if (characterUsed.contains("4")) {
            passwordBuilder.append(CHARCTERS);
        }
        if (characterUsed.contains("5")) {
            passwordBuilder.append(LARGE_CHARACTERS);
            passwordBuilder.append(SMALL_CHARACTERS);
            passwordBuilder.append(NUMBERS);
            passwordBuilder.append(CHARCTERS);
        }
        for (int i = 0; i < passwordLength; i++) {
            int index = randomChar.nextInt(passwordBuilder.length());
            password.append(passwordBuilder.charAt(index));
        }
        return password.toString();
    }

    public void setWordEndOrFront(String wordEndOrFront) {
        this.wordEndOrFront = wordEndOrFront;
    }

    public void setCustomWord(String customWord) {
        this.customWord = customWord;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public ArrayList<Password> findPassword(int passwordLength) {
        ArrayList<Password> foundPasswords = new ArrayList<>();
        for (Password password : passwords) {
            if (passwordLength == password.getPasswordLength()) {
                foundPasswords.add(password);
            }
        }
        return foundPasswords;
    }

    public ArrayList<Password> findAllPasswords() {
        ArrayList<Password> foundPasswords = new ArrayList<>();
        for (Password password : passwords) {
            foundPasswords.add(password);
        }
        return foundPasswords;
    }

    public void deleteALLPasswords(boolean deleteAll) {
        if (deleteAll) {
            passwords.clear();
        }
    }

    public void deletePassword(int passwordLength) {
        ArrayList<Password> foundPasswords = findPassword(passwordLength);
        for (Password password : foundPasswords) {
            passwords.remove(password);
        }
    }
}







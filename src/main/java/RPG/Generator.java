package RPG;

import java.util.ArrayList;
import java.util.Random;

public class Generator {

    private ArrayList<Password> passwords;
    private String largeCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String smallCharacters = "abcdefghijklmnopqrstuvwxyz";
    private String characters = "?.-!/@€&#%*-+<>";
    private String numbers = "1234567890";
    private String password = "";
    private Random randomChar;

    public Generator(){
        randomChar = new Random();
        passwords = new ArrayList<>();
    }

    public void addPassword(int passwordLength){
        password = "";
        password = generatePassword(passwordLength);
        passwords.add(new Password(password, passwordLength));
        System.out.println(password);
    }

    public String generatePassword(int passwordLength){
        String allCharacters = largeCharacters + smallCharacters + characters + numbers;
        for(int i = 0; i < passwordLength; i++){
            password += allCharacters.charAt(randomChar.nextInt(allCharacters.length()));
        }
        return password;
    }

    public ArrayList<Password> findPassword(int passwordLength){
        ArrayList<Password> foundPasswords = new ArrayList<>();
        for(Password password : passwords){
            if(passwordLength == password.getPasswordLength()){
                foundPasswords.add(password);
            }
        }
        return foundPasswords;
    }

    public void deleteALLPasswords(boolean deleteAll){
        if(deleteAll){
            passwords.clear();
        }
    }

    public void deletePassword(int passwordLength){
        ArrayList<Password> foundPasswords = findPassword(passwordLength);
            for(Password password : foundPasswords){
                passwords.remove(password);
            }
    }

    public ArrayList<Password> findAllPasswords(){
        ArrayList<Password> foundPasswords = new ArrayList<>();
        for(Password password : passwords){
            foundPasswords.add(password);
        }
        return foundPasswords;
    }

}






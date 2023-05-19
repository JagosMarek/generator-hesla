package RPG;

public class Password {

    private String password;
    private int passwordLength;

    public Password(String password, int passwordLength){
        this.password = password;
        this.passwordLength = passwordLength;
    }

    public String getPassword() {
        return password;
    }

    public int getPasswordLength() {
        return passwordLength;
    }

    @Override
    public String toString(){
        return String.format(password);
    }
}

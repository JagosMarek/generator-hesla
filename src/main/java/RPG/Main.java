package RPG;

public class Main {
    public static void main(String[] args) {

        UI ui = new UI();
        ui.addPassword();
        ui.addPassword();
        ui.addPassword();
        ui.getAllPasswords();
        ui.findPasswords();
        ui.addPassword();
        ui.deletePassword();
        ui.getAllPasswords();
        ui.deleteAllPasswords();
        ui.getAllPasswords();



        //oštřit aby nebyla nula a max 50 ------ DONE
        //nabídnout jaká znaky chce použít ------ DONE
        //vrátit mu i sílu hesla ------ DONE
        //nabídnout jestli chce do hesla zahrnout i svoje vlastní slovo
        //schovat pasword pomocí ### ------ NOPE
        //dodělat ui
    }
}
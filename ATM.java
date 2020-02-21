package SimpleATM;

import java.io.IOException;

public class ATM extends OptionsMenu {
    
    /*main method
    *throw IOException?
    *instantiate class "OptionsMenu"
    *call method "getLogin()" to perform user operations
    */
    public static void main (String[] args) throws IOException {
        OptionsMenu optionsMenu = new OptionsMenu();
        optionsMenu.getLogin();
    }
}

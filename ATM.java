package SimpleATM;

import java.io.IOException;

public class ATM extends OptionsMenu {
    
    /*main method
    *throw IOException?
    *instantiate class "OptionMenu"
    *call method "getLogin()" to perform user operations
    */
    public static void main (String[] args) throws IOException {
        OptionsMenu optionMenu = new OptionsMenu();
        optionMenu.getLogin();
    }
}

/*
NOTES
*retrieve user data from a database
*would be interesting to add adjustable amounts, eg, lowest amount that can be withdrawn etc in Accounts.java
*/
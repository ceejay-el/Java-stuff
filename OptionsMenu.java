package SimpleATM;

//import statements
import java.io.IOException;
import static java.lang.System.exit;
import static java.lang.System.out;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionsMenu extends Accounts {
    //variable declarations
    Scanner userMenuInput = new Scanner(System.in);
    DecimalFormat cashFormat = new DecimalFormat("'$' ###,##0.00");
    HashMap<Integer, Integer> accNumAndPin = new HashMap<Integer, Integer>();
    int selection;
    //End of Variable declarations
    
    /*method "getLogin()" to prompt user for input 
    *allow loop and decision control
    *if user input ok, proceed
    *if user input not ok, "Wrong Accounts or PIN, Try again" or "Invalid"
    *allow only 3 failed attempts, else terminate process and 'report'
    *'report' prompts JOptionsPane
    *throw IOException?
    */
    //user input
    public void userLoginInfo() {
       /*hard coded AccNum and PinNum
        *REVISE: retrieve user data from database
        */
       accNumAndPin.put(123456, 9876);
       out.print("Enter Account Number: ");
       setAccNum(userMenuInput.nextInt());
       out.print("PIN: ");
       setPinNum(userMenuInput.nextInt()); 
    }
    
    public void getLogin() throws IOException {
        out.print("WELCOME!\n\n");
        int x = 1;
        do {
            try {
                userLoginInfo();
            } catch(Exception e) {  //REVISE: Use specific exception
                out.print("Invalid. Enter numbers only");
                threeUserAttempts();
            }
            for (Entry<Integer, Integer> userEntry: accNumAndPin.entrySet()) {
                if (userEntry.getKey() == getAccNum() && userEntry.getValue() == getPinNum()) {
                    getAccountType();
                } else {
                    //method: allows three user attempts else "reports" and ends program
                    threeUserAttempts();
                }
            }
        } while (x == 1);
    }
    
    /*ATM Menu: Checking acc, Savings acc and Exit
    *Accounts Menu: Balance, Withdraw, Deposit, Exit
    */
    public void getAccountType() {
        out.println("1. Checkings");
        out.println("2. Savings");
        out.println("3. Back");
        out.println("Select Account: ");
        selection = userMenuInput.nextInt();
        
        switch (selection) {
            case 1: checkingsAccMenu();
                    break;
            case 2: savingsAccMenu();
                    break;
            case 3: out.println("Thank you for using our Services");
                    userLoginInfo();
                    break;
            default: out.println("Invalid. Select only 1, 2 or 3");
                    getAccountType();
        }
    }
    
    /*CHECKINGS ACC Menu
    *Items: Balance, Withdraw, Deposit, Back
    */
    public void checkingsAccMenu() {
        out.println("1. Check Balance");
        out.println("2. Withdraw");
        out.println("3. Deposit");
        out.println("4. Back");
        out.println("Select option: ");
        selection = userMenuInput.nextInt();
        
        switch (selection) {
            case 1: getCheckingsAccBal();
                    break;
            case 2: withdrawCheckings();
                    break;
            case 3: depositCheckings();
                    break;
            case 4: getAccountType();
                    break;
            default: out.println("Invalid. Select only 1, 2, 3 or 4");
                    getAccountType(); 
        }
    }
    
    /*SAVINGS ACC Menu
    *Items: Balance, Transfer to, Transfer from, Back
    */
    public void savingsAccMenu() {
        out.println("1. Check Balance");
        out.println("2. Transfer to Checkings Account");
        out.println("3. Transfer from Checkings Account");
        out.println("4. Back");
        out.println("Select option: ");
        selection = userMenuInput.nextInt();
        
        switch (selection) {
            case 1: getSavingsAccBal();
                    break;
            case 2: transferToCheckings();
                    break;
            case 3: transferFromCheckings();
                    break;
            case 4: getAccountType();
                    break;
            default: out.println("Invalid. Select only 1, 2, 3 or 4");
                    getAccountType(); 
        }
    }
    
    public void threeUserAttempts () {
        out.println("Wrong Account Number or PIN Number");
        out.print("Try again?\n");
        
        int userAttempts = 1;
        while (userAttempts <= 3) {
            userLoginInfo();
            int tries;
            tries = 3 - userAttempts;
            out.println("You have " + tries + " attempts remaining\n");
            userAttempts++;
        }
        //TODO Code here: open JOptionsPane
        exit(0);
    }
    
}
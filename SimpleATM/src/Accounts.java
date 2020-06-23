import java.text.DecimalFormat;
import java.util.Scanner;

import static java.lang.System.out;

public class Accounts {
    //variable declarations
    Scanner userInput = new Scanner(System.in);
    DecimalFormat cashFormat = new DecimalFormat("'$' ###,##0.00");
    private int accNum, PinNum;
    private double checkingsBal, savingsBal;
    private double amount;

    /*methods to set and get customer account number
     *methods to set and get customer PIN
     */
    //set customer account number
    public int setAccNum(int accNum) {
        this.accNum = accNum;
        return accNum;
    }
    //get account number
    public int getAccNum() {
        return accNum;
    }
    //set customer PIN
    public int setPinNum(int PinNum) {
        this.PinNum = PinNum;
        return PinNum;
    }
    //get account PIN
    public int getPinNum() {
        return PinNum;
    }

    /*CHECKINGS ACCOUNT
     *calculate checkings account withdrawal
     *calculate checkings account deposit
     *customer withdrawal transaction
     *customer deposit transaction
     */
    public double checkingsWithdraw(double amount) {
        checkingsBal = (checkingsBal - amount);
        return checkingsBal;
    }

    public double checkingsDeposit(double amount) {
        checkingsBal = (checkingsBal + amount);
        return checkingsBal;
    }

    public void getCheckingsAccBal() {
        out.println("Account Balance: " + cashFormat.format(checkingsBal));
    }

    public void withdrawCheckings() {
        out.println("Current Balance: " + cashFormat.format(checkingsBal));
        out.print("Enter Amount to Withdraw: ");
        amount = userInput.nextInt();
        if ((checkingsBal - amount) >= 0 || (checkingsBal - amount) <= 5000.00) {
            checkingsWithdraw(amount);
            out.println("New Account Balance: " + cashFormat.format(checkingsBal));
        } else if ((checkingsBal - amount) > 5000.00) {
            out.println("Cannot withdraw amounts in excess of 5,000.00\nTry Again?");
        } else {
            out.println("Balance cannot be negative");
        }
    }

    public void depositCheckings() {
        out.println("Current Balance: " + cashFormat.format(checkingsBal));
        out.println("Enter Amount to Deposit: ");
        amount = userInput.nextInt();
        if ((checkingsBal + amount) < 10000.00) {
            checkingsDeposit(amount);
            out.println("New Account Balance: " + cashFormat.format(checkingsBal));
        } else {
            out.print("Amount too large. Visit our nearest branch");
        }
    }

    /*SAVINGS ACCOUNT
     *calculate savings account withdrawal
     *calculate savings account deposit
     *transfer to checkings account
     *transfer from checkings account
     */
    public double savingsWithdraw(double amount) {
        savingsBal = (savingsBal - amount);
        return savingsBal;
    }

    public double savingsDeposit(double amount) {
        savingsBal = (savingsBal + amount);
        return savingsBal;
    }

    public void getSavingsAccBal() {
        out.println("Savings Account Balance: " + cashFormat.format(checkingsBal));
    }

    public void transferToCheckings() {
        out.println("Current Balance: " + cashFormat.format(checkingsBal));
        out.print("Enter Amount to Transfer: ");
        amount = userInput.nextInt();
        if ((savingsBal - amount) >= 0 || (savingsBal - amount) <= 5000.00) {
            checkingsDeposit(amount);
            savingsWithdraw(amount);
            out.println("New Account Balance: " + cashFormat.format(savingsBal));
        } else if ((checkingsBal - amount) > 5000.00) {
            out.println("Cannot transfer amounts in excess of 5,000.00\nTry Again?");
        } else {
            out.println("Balance cannot be negative");
        }
    }

    public void transferFromCheckings() {
        out.println("Current Balance: " + cashFormat.format(checkingsBal));
        out.println("Enter Amount to Transfer: ");
        amount = userInput.nextInt();
        if ((checkingsBal + amount) < 10000.00) {
            checkingsWithdraw(amount);
            savingsDeposit(amount);
            out.println("New Account Balance: " + cashFormat.format(checkingsBal));
        } else {
            out.print("Amount too large. Visit our nearest branch");
        }
    }
}